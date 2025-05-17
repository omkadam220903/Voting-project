package com.capgemini.voting_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.voting_project.model.Candidates;

public interface CandidateRepository  extends JpaRepository<Candidates, Long>{

}
