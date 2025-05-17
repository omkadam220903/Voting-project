package com.capgemini.voting_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.voting_project.model.Votes;

public interface VoteRepository extends JpaRepository<Votes, Long> {

}
