package com.capgemini.voting_project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capgemini.voting_project.model.Elections;
import com.capgemini.voting_project.model.Users;
import com.capgemini.voting_project.service.ElectionsService;
import com.capgemini.voting_project.service.UserService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*") 
public class UserController {

	private final UserService service;

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Users>> getAllUsers() {
		List<Users> users = service.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Users> getUsers(@PathVariable Long id) {
		Users users = service.getUsersById(id);
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}

	@PostMapping
	public ResponseEntity<Users> createUsers(@RequestBody Users users) {
		Users saved = service.createUsers(users);
		return ResponseEntity.status(HttpStatus.CREATED).location(URI.create("/api/users/" + saved.getId()))
				.body(saved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Users> updateUsers(@PathVariable Long id, @RequestBody Users newuser) {
		Users updated = service.updateUsers(id, newuser);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Users> patchUsers(@PathVariable Long id, @RequestBody Users patch) {
		Users updated = service.patchUsers(id, patch);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUsers(@PathVariable Long id) {
		service.deleteUsers(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}