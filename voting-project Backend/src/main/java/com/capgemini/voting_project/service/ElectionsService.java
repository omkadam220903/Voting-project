package com.capgemini.voting_project.service;

import java.util.List;

import com.capgemini.voting_project.model.Elections;

public interface ElectionsService {
	List<Elections> getAllElections();

	Elections getElectionsById(Long id);

	Elections createElections(Elections elections);

	Elections updateElections(Long id, Elections elections);

	Elections patchElections(Long id, Elections elections);

	void deleteElections(Long id);
}

