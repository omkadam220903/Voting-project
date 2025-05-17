package com.capgemini.voting_project.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
public class Elections {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

@NotBlank(message = "Title is mandatory")
private String title;

@NotNull(message = "start date must be provided")
private LocalDate startDate;

@NotNull(message = "end date must be provided")
private LocalDate endDate;

@NotBlank(message = "status is mandatory")
private String status;


public Elections() {
}


public Elections(Long id, @NotBlank(message = "Title is mandatory") String title,
		@NotNull(message = "start date must be provided") LocalDate startDate,
		@NotNull(message = "end date must be provided") LocalDate endDate,
		@NotBlank(message = "status is mandatory") String status) {
	super();
	this.id = id;
	this.title = title;
	this.startDate = startDate;
	this.endDate = endDate;
	this.status = status;
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
}


public LocalDate getStartDate() {
	return startDate;
}


public void setStartDate(LocalDate startDate) {
	this.startDate = startDate;
}


public LocalDate getEndDate() {
	return endDate;
}


public void setEndDate(LocalDate endDate) {
	this.endDate = endDate;
}


public String getStatus() {
	return status;
}


public void setStatus(String status) {
	this.status = status;
}


@Override
public String toString() {
	return "Elections [id=" + id + ", title=" + title + ", startDate=" + startDate + ", endDate=" + endDate
			+ ", status=" + status + "]";
}



}
