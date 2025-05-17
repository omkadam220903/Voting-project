package com.capgemini.voting_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.voting_project.model.Elections;

public interface ElectionsRepository extends JpaRepository<Elections, Long> {
}
