package com.capgemini.voting_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.voting_project.exception.VotesNotFoundException;

import com.capgemini.voting_project.model.Votes;
import com.capgemini.voting_project.repository.VoteRepository;

import jakarta.validation.Valid;
@Service
public class VoteServiceImpl implements VoteService {
	
	private final VoteRepository repository;
	
	@Autowired

	public VoteServiceImpl(VoteRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<Votes> getAllVotes() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Votes getVotesById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id)
				.orElseThrow(()->new VotesNotFoundException("Votes not found with Id"+ id));
	}

	@Override
	public Votes createVotes(@Valid Votes votes) {
		// TODO Auto-generated method stub
		return repository.save(votes);
	}

	@Override
	public Votes updateVotes(Long id, Votes updated) {
	  Votes existing=repository.findById(id)
			  .orElseThrow(()->new VotesNotFoundException("votes not found with Id:"+id));
	    existing.setUserID(updated.getUserID());
		existing.setCandidateID(updated.getCandidateID());
		existing.setVoteDate(updated.getVoteDate());
		
		
		return repository.save(existing);
	}

	@Override
	public Votes patchVotes(Long id, Votes patch) {
		Votes existing = repository.findById(id)
				.orElseThrow(() -> new VotesNotFoundException("votes not found with ID: " + id));

		if (patch.getUserID() != null) {
			existing.setUserID(patch.getUserID());
		}
		if (patch.getCandidateID() != null) {
			existing.setCandidateID(patch.getCandidateID());
		}
		if (patch.getVoteDate() != null) {
			existing.setVoteDate(patch.getVoteDate());
		}
		
		
		return repository.save(existing);
	}

	@Override
	public void deleteVotes(Long id) {
		if(!repository.existsById(id)) {
			throw new VotesNotFoundException("cannot delete. Votes not found with Id:"+id);
		}
		repository.deleteById(id);
		
	}
 
}
