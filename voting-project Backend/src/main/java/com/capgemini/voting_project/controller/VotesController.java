package com.capgemini.voting_project.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.voting_project.model.Elections;
import com.capgemini.voting_project.model.Votes;
import com.capgemini.voting_project.service.VoteService;

@RestController
@RequestMapping("/api/votes")
@CrossOrigin(origins = "*") 
public class VotesController {
	private final VoteService service;
    @Autowired
	public VotesController(VoteService service) {
		super();
		this.service = service;
	}
    
    @GetMapping
    public ResponseEntity<List<Votes>>getAllVotes(){
    	List<Votes>votes=service.getAllVotes();
    	return ResponseEntity.status(HttpStatus.OK).body(votes);
    }
    
    @GetMapping("/{id}")
	public ResponseEntity<Votes> getVotes(@PathVariable Long id) {
    	Votes votes = service.getVotesById(id);
		return ResponseEntity.status(HttpStatus.OK).body(votes);
	}

	@PostMapping
	public ResponseEntity<Votes> createVotes(@RequestBody Votes votes) {
		Votes saved = service.createVotes(votes);
		return ResponseEntity.status(HttpStatus.CREATED).location(URI.create("/api/votes/" + saved.getId()))
				.body(saved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Votes> updateVotes(@PathVariable Long id, @RequestBody Votes newVotes) {
		Votes updated = service.updateVotes(id, newVotes);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Votes> patchVotes(@PathVariable Long id, @RequestBody Votes patch) {
		Votes updated = service.patchVotes(id, patch);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVotes(@PathVariable Long id) {
		service.deleteVotes(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	

}
