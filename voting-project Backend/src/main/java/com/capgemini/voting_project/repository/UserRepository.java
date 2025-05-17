package com.capgemini.voting_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.voting_project.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
}
