package com.tidcode.pojodojo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tidcode.pojodojo.entity.Person;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class TheController {

	private List<Person> people = new ArrayList<>();

	@PostConstruct
	public void populatePeople() {
		Person mano = new Person(1L, "Mano", "Silva", 23);
		Person truta = new Person(2L, "Truta", "Fulano", 30);
		Person tiu = new Person(3L, "Tiu", "Demais", 24);
		this.people.add(mano);
		this.people.add(truta);
		this.people.add(tiu);
	}

	@GetMapping("/people")
	public List<Person> getPeople() {
		System.out.println(people);
		return this.people;
	}

}
