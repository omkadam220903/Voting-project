package com.capgemini.voting_project.service;

import java.util.List;

import com.capgemini.voting_project.model.Votes;

public interface VoteService {
	List<Votes> getAllVotes();
	Votes getVotesById(Long id);
	Votes createVotes(Votes votes);
	Votes updateVotes(Long id,Votes votes);
	Votes patchVotes(Long id,Votes votes);
	void deleteVotes(Long id);

}
