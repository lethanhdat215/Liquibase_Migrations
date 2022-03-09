package com.example.liquibase_migrations.controller;

import com.example.liquibase_migrations.entity.Person;
import com.example.liquibase_migrations.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("person")
public class Controller {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("person")
    public String createPerson(@RequestParam String name) {
        personRepository.save(new Person(name,"1m67"));
        return personRepository.findByName(name)+ "save successfully";
    }

    @GetMapping("person")
    public List<Person> getAllThePeople() {
        return personRepository.findAll();
    }
}
