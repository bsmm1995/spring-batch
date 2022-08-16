package com.bsmm.springbatch.controller;

import com.bsmm.springbatch.domain.Person;
import com.bsmm.springbatch.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping
    ResponseEntity<Person> create(@RequestBody @Valid Person data) {
        log.info("Create person.");
        return new ResponseEntity<>(personService.create(data), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<Person> update(@PathVariable long id, @RequestBody @Valid Person data) {
        log.info("Update person.");
        return ResponseEntity.ok().body(personService.update(id, data));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Long> deleteById(@PathVariable long id) {
        log.info("Get person by id.");
        return ResponseEntity.ok().body(personService.deleteById(id));
    }
}
