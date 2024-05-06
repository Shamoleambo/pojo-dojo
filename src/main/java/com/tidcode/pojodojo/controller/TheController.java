package com.tidcode.pojodojo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tidcode.pojodojo.entity.Person;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class TheController {

	private List<Person> people;

	@PostConstruct
	public void populatePeople() {
		this.people = new ArrayList<>();

		Person mano = new Person(1L, "Mano", "Silva", 23);
		Person truta = new Person(2L, "Truta", "Fulano", 30);
		Person tiu = new Person(3L, "Tiu", "Demais", 24);

		this.people.add(mano);
		this.people.add(truta);
		this.people.add(tiu);
	}

	@GetMapping("/people")
	public List<Person> getPeople() {
		return this.people;
	}

	@GetMapping("/person/{id}")
	public Person getSinglePerson(@PathVariable int id) {

		if (id >= this.people.size() || id < 0) {
			throw new PersonNotFoundException("Person Id not found " + id);
		}
		return this.people.get(id);
	}

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
