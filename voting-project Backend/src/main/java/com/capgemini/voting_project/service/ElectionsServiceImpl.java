package com.capgemini.voting_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.voting_project.model.Elections;
import com.capgemini.voting_project.exception.ElectionsNotFoundException;
import com.capgemini.voting_project.repository.ElectionsRepository;

import jakarta.validation.Valid;

import java.util.List;

@Service
public class ElectionsServiceImpl implements ElectionsService {

	private final ElectionsRepository repository;

	@Autowired
	public ElectionsServiceImpl(ElectionsRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Elections> getAllElections() {
		return repository.findAll();
	}

	@Override
	public Elections getElectionsById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ElectionsNotFoundException("Elections not found with ID: " + id));
	}

	@Override
	public Elections createElections(@Valid Elections elections) {
		return repository.save(elections);
	}

	@Override
	public Elections updateElections(Long id, @Valid Elections updated) {
		Elections existing = repository.findById(id)
				.orElseThrow(() -> new ElectionsNotFoundException("Elections not found with ID: " + id));
		existing.setTitle(updated.getTitle());
		existing.setStartDate(updated.getStartDate());
		existing.setEndDate(updated.getEndDate());
		existing.setStatus(updated.getStatus());
		
		return repository.save(existing);
	}

	@Override
	public Elections patchElections(Long id, Elections patch) {
		Elections existing = repository.findById(id)
				.orElseThrow(() -> new ElectionsNotFoundException("Elections not found with ID: " + id));

		if (patch.getTitle() != null) {
			existing.setTitle(patch.getTitle());
		}
		if (patch.getStartDate() != null) {
			existing.setStartDate(patch.getStartDate());
		}
		if (patch.getEndDate() != null) {
			existing.setEndDate(patch.getEndDate());
		}
		if (patch.getStatus() != null) {
			existing.setStatus(patch.getStatus());
		}
		
		return repository.save(existing);
	}

	@Override
	public void deleteElections(Long id) {
		if (!repository.existsById(id)) {
			throw new ElectionsNotFoundException("Cannot delete. Elections not found with ID: " + id);
		}
		repository.deleteById(id);
	}
}