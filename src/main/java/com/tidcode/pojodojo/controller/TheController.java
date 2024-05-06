package com.tidcode.pojodojo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tidcode.pojodojo.entity.Person;

@RestController
@RequestMapping("/api")
public class TheController {

	@GetMapping("/person")
	public Person getPerson() {
		Person person = new Person("Mano", "Silva", 23);
		return person;
	}

}
