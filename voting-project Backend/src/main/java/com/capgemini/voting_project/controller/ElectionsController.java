package com.capgemini.voting_project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capgemini.voting_project.model.Elections;
import com.capgemini.voting_project.service.ElectionsService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/elections")
@CrossOrigin(origins = "*") 
public class ElectionsController {

	private final ElectionsService service;

	@Autowired
	public ElectionsController(ElectionsService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Elections>> getAllElections() {
		List<Elections> elections = service.getAllElections();
		return ResponseEntity.status(HttpStatus.OK).body(elections);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Elections> getElections(@PathVariable Long id) {
		Elections elections = service.getElectionsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(elections);
	}

	@PostMapping
	public ResponseEntity<Elections> createElections(@RequestBody Elections elections) {
		Elections saved = service.createElections(elections);
		return ResponseEntity.status(HttpStatus.CREATED).location(URI.create("/api/elections/" + saved.getId()))
				.body(saved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Elections> updateElections(@PathVariable Long id, @RequestBody Elections newElec) {
		Elections updated = service.updateElections(id, newElec);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Elections> patchElections(@PathVariable Long id, @RequestBody Elections patch) {
		Elections updated = service.patchElections(id, patch);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteElections(@PathVariable Long id) {
		service.deleteElections(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}

