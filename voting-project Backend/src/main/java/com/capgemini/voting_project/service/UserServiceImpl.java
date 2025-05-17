package com.capgemini.voting_project.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.capgemini.voting_project.model.Users;
import com.capgemini.voting_project.exception.ElectionsNotFoundException;
import com.capgemini.voting_project.exception.UserNotFoundException;

import com.capgemini.voting_project.repository.UserRepository;

import jakarta.validation.Valid;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository repository;

	@Autowired
	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Users> getAllUsers() {
		return repository.findAll();
	}

	@Override
	public Users getUsersById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
	}

	@Override
	public Users createUsers(@Valid Users users) {
		return repository.save(users);
	}

	@Override
	public Users updateUsers(Long id, @Valid Users updated) {
		Users existing = repository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
		existing.setName(updated.getName());
		existing.setAge(updated.getAge());
		existing.setConstituency(updated.getConstituency());
		existing.setEmail(updated.getEmail());
		existing.setPhone(updated.getPhone());
		existing.setPassword(updated.getPassword());
		existing.setVoterId(updated.getVoterId());
		existing.setUserType(updated.getUserType());
		return repository.save(existing);
	}

	@Override
	public Users patchUsers(Long id, Users patch) {
		Users existing = repository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));

		if (patch.getName() != null) {
			existing.setName(patch.getName());
		}
		if (patch.getAge() != null) {
			existing.setAge(patch.getAge());
		}
		if (patch.getConstituency() != null) {
			existing.setConstituency(patch.getConstituency());
		}
		if (patch.getEmail() != null) {
			existing.setEmail(patch.getEmail());
		}
		if (patch.getPhone() != null) {
			existing.setPhone(patch.getPhone());
		}
		if (patch.getPassword() != null) {
			existing.setPassword(patch.getPassword());
		}
		if (patch.getVoterId() != null) {
			existing.setVoterId(patch.getVoterId());
		}
		if (patch.getUserType() != null) {
			existing.setUserType(patch.getUserType());
		}
		
		return repository.save(existing);
	}

	@Override
	public void deleteUsers(Long id) {
		if (!repository.existsById(id)) {
			throw new ElectionsNotFoundException("Cannot delete. Elections not found with ID: " + id);
		}
		repository.deleteById(id);
	}
}
