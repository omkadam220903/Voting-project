package com.capgemini.voting_project.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Votes {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
	@NotNull(message="UserId is mandatory")
	Long userID;
	@NotNull(message="CandidateId is mandatory")
	Long candidateID;
	
	Long electionID;
	
	@NotNull(message="VoteDate is mandatory")
	LocalDate voteDate;
	
	public Votes() {
		
	}


	public Votes(Long id, @NotNull(message = "UserId is mandatory") Long userID,
			@NotNull(message = "CandidateId is mandatory") Long candidateID, Long electionID,
			@NotNull(message = "VoteDate is mandatory") LocalDate voteDate) {
		super();
		this.id = id;
		this.userID = userID;
		this.candidateID = candidateID;
		this.electionID = electionID;
		this.voteDate = voteDate;
	}



	public Long getElectionID() {
		return electionID;
	}


	public void setElectionID(Long electionID) {
		this.electionID = electionID;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public Long getCandidateID() {
		return candidateID;
	}

	public void setCandidateID(Long candidateID) {
		this.candidateID = candidateID;
	}

	public LocalDate getVoteDate() {
		return voteDate;
	}

	public void setVoteDate(LocalDate voteDate) {
		this.voteDate = voteDate;
	}



	@Override
	public String toString() {
		return "Votes [id=" + id + ", userID=" + userID + ", candidateID=" + candidateID + ", electionID=" + electionID
				+ ", voteDate=" + voteDate + "]";
	}

	

}
