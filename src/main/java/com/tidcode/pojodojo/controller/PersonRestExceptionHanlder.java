package com.tidcode.pojodojo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PersonRestExceptionHanlder {

	@ExceptionHandler
	public ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundException e) {
		PersonErrorResponse errorResponse = new PersonErrorResponse();

		errorResponse.setMessage(e.getMessage());
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<PersonErrorResponse> handleException(Exception e) {
		PersonErrorResponse errorResponse = new PersonErrorResponse();

		System.out.println("MANOOOOOO!");

		errorResponse.setMessage(e.getMessage());
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
