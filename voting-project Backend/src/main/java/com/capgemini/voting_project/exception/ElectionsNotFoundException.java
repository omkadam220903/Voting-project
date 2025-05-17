package com.capgemini.voting_project.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ElectionsNotFoundException extends RuntimeException {
	public ElectionsNotFoundException(String message) {
		super(message);
	}
}
