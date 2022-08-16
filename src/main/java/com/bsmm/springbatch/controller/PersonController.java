package com.bsmm.springbatch.controller;

import com.bsmm.springbatch.domain.Person;
import com.bsmm.springbatch.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/persons")
@RequiredArgsConstructor
@Slf4j
public class PersonController {
    private final PersonService personService;

    @GetMapping
    ResponseEntity<List<Person>> getAll() {
        log.info("Get all persons.");
        return ResponseEntity.ok().body(personService.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Person> getById(@PathVariable long id) {
        log.info("Get person by id.");
        return ResponseEntity.ok().body(personService.getById(id));
    }
}
