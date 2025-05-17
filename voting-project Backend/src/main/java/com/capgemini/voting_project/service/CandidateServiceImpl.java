package com.capgemini.voting_project.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.capgemini.voting_project.exception.CandidatesNotFoundException;
import com.capgemini.voting_project.model.Candidates;
import com.capgemini.voting_project.repository.CandidateRepository;

import jakarta.validation.Valid;

@Service
public class CandidateServiceImpl implements CandidateService{
	
    private final CandidateRepository repository;
    
    @Autowired
    public CandidateServiceImpl(CandidateRepository repository) {
	  super();
	  this.repository = repository;
    }

	@Override
	public List<Candidates> getAllCandidates() {
		
		return repository.findAll();
	}

	@Override
	public Candidates getCandidatesById(Long id) {
		return repository.findById(id)
				.orElseThrow(() ->new CandidatesNotFoundException("candidates not found with Id:"+id));
	}

	@Override
	public Candidates createCandidates(String name,String election,String party,String position,String manifesto,MultipartFile file)throws IOException {
		String UPLOAD_DIR="uploads/candidates/";
		Files.createDirectories(Paths.get(UPLOAD_DIR));
		
		String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
		Path filePath = Paths.get(UPLOAD_DIR, fileName);
		Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
		
		Candidates candidate=new Candidates();
		candidate.setName(name);
		candidate.setElection(election);
		candidate.setParty(party);
		candidate.setPosition(position);
		candidate.setManifesto(manifesto);
		candidate.setCandidateImage(fileName);
		return repository.save(candidate);
	}

	@Override
	public Candidates updateCandidates(Long id, Candidates updated) {
		Candidates existing=repository.findById(id)
				.orElseThrow(() ->new CandidatesNotFoundException("candidates not found with id:"+id));
		existing.setName(updated.getName());
		existing.setElection(updated.getElection());
		existing.setParty(updated.getParty());
		existing.setPosition(updated.getPosition());
		existing.setManifesto(updated.getManifesto());
		return repository.save(existing);
	}

	@Override
	public Candidates patchCandidates(Long id, Candidates patch) {
		Candidates existing =repository.findById(id)
				.orElseThrow(() ->new CandidatesNotFoundException("Candidates not found with id:"+id));
		
		if(patch.getName() !=null) {
			existing.setName(patch.getName());
		}

		if(patch.getElection() !=null) {
			existing.setElection(patch.getElection());
		}

		if(patch.getParty() !=null) {
			existing.setParty(patch.getParty());
		}

		if(patch.getPosition() !=null) {
			existing.setPosition(patch.getPosition());
		}

		if(patch.getManifesto() !=null) {
			existing.setManifesto(patch.getManifesto());
		}
				
		return repository.save(existing);
	}

	@Override
	public void deleteCandidates(Long id) {
		if(!repository.existsById(id)) {
		throw new CandidatesNotFoundException("cannot delete. Candidate not found with id:"+id);
		
	}
	repository.deleteById(id);
	}
   
   
}
