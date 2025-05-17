package com.capgemini.voting_project.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.capgemini.voting_project.model.Candidates;

public interface CandidateService {
	List<Candidates>getAllCandidates();
	Candidates getCandidatesById(Long id);
	Candidates createCandidates(String name,String election,String party,String position, String manifesto, MultipartFile file)throws IOException;
	Candidates updateCandidates(Long id, Candidates candidates);
	Candidates patchCandidates(Long id, Candidates candidates);

	void deleteCandidates(Long id);

}
