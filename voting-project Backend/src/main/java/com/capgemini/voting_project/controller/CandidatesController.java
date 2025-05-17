package com.capgemini.voting_project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;


import com.capgemini.voting_project.model.Candidates;
import com.capgemini.voting_project.model.Elections;
import com.capgemini.voting_project.service.CandidateService;
import com.capgemini.voting_project.service.ElectionsService;



import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin(origins = "*") 
public class CandidatesController {

	private final CandidateService service;

	@Autowired
	public CandidatesController(CandidateService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Candidates>> getAllCandidates() {
		List<Candidates> candidates = service.getAllCandidates();
		return ResponseEntity.status(HttpStatus.OK).body(candidates);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Candidates> getCandidates(@PathVariable Long id) {
		Candidates candidates = service.getCandidatesById(id);
		return ResponseEntity.status(HttpStatus.OK).body(candidates);
	}

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Candidates> createCandidates(@RequestParam ("name") String name,
			@RequestParam ("election") String election,@RequestParam ("party") String party,
			@RequestParam ("position") String position,@RequestParam ("manifesto") String manifesto,
			@RequestParam ("candidateImage")  MultipartFile candidateImage)throws IOException {
		Candidates saved = service.createCandidates(name,election,party,position,manifesto,candidateImage);
		return ResponseEntity.status(HttpStatus.CREATED).location(URI.create("/api/candidates/" + saved.getID()))
				.body(saved);
	}
	
	@GetMapping("/image/{filename}")
	public ResponseEntity<Resource> getImage(@PathVariable String filename) throws IOException {
		// Point to the correct subdirectory
		Path filePath = Paths.get("uploads/candidates", filename);

		// Check if file exists
		if (!Files.exists(filePath)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		// Create resource
		Resource resource = new UrlResource(filePath.toUri());

		// Determine content type
		String contentType = Files.probeContentType(filePath);
		if (contentType == null) {
			contentType = "application/octet-stream"; // default fallback
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).body(resource);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Candidates> updateCandidates(@PathVariable Long id, @RequestBody Candidates newcandi) {
		Candidates updated = service.updateCandidates(id, newcandi);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Candidates> patchCandidates(@PathVariable Long id, @RequestBody Candidates patch) {
		Candidates updated = service.patchCandidates(id, patch);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCandidates(@PathVariable Long id) {
		service.deleteCandidates(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}