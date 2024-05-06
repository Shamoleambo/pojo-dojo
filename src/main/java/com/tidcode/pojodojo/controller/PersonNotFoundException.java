package com.tidcode.pojodojo.controller;

public class PersonNotFoundException extends RuntimeException {

	public PersonNotFoundException(String message) {
		super(message);
	}

	public PersonNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PersonNotFoundException(Throwable cause) {
		super(cause);
	}

}
