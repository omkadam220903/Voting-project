package com.capgemini.voting_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Candidates {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ID;
	
	@NotBlank(message="Name is mandatory")
	private String name;
	
	@NotBlank(message="election is mandatory")
	private String election;
	
	@NotBlank(message="party is mandatory")
	private String party;
	
	@NotBlank(message="position is mandatory")
	 private String position;
	
	@NotBlank(message="manifesto is mandatory")
	private String manifesto;
	
	private String candidateImage;
	
	public Candidates() {
		
	}

	public Candidates(Long iD, @NotBlank(message = "Name is mandatory") String name,
			@NotBlank(message = "election is mandatory") String election,
			@NotBlank(message = "party is mandatory") String party,
			@NotBlank(message = "position is mandatory") String position,
			@NotBlank(message = "manifesto is mandatory") String manifesto,String candidateImage ) {
		super();
		ID = iD;
		this.name = name;
		this.election = election;
		this.party = party;
		this.position = position;
		this.manifesto = manifesto;
		this.candidateImage=candidateImage;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getElection() {
		return election;
	}

	public void setElection(String election) {
		this.election = election;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getManifesto() {
		return manifesto;
	}

	public void setManifesto(String manifesto) {
		this.manifesto = manifesto;
	}
	public String getCandidateImage() {
		return candidateImage;
	}
	public void setCandidateImage(String candidateImage) {
		this.candidateImage=candidateImage;
	}

	@Override
	public String toString() {
		return "Candidates [ID=" + ID + ", name=" + name + ", election=" + election + ", party=" + party + ", position="
				+ position + ", manifesto=" + manifesto +",candidateImage="+candidateImage+ "]";
	}
	

}
