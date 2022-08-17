package com.bsmm.springbatch.controller;

import com.bsmm.springbatch.domain.CreditCardDto;
import com.bsmm.springbatch.service.CreditCardService;
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
    private final CreditCardService creditCardService;

    @GetMapping
    ResponseEntity<List<CreditCardDto>> getAll() {
        log.info("Get all persons.");
        return ResponseEntity.ok().body(creditCardService.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<CreditCardDto> getById(@PathVariable long id) {
        log.info("Get person by id.");
        return ResponseEntity.ok().body(creditCardService.getById(id));
    }

    @PostMapping
    ResponseEntity<CreditCardDto> create(@RequestBody @Valid CreditCardDto data) {
        log.info("Create person.");
        return new ResponseEntity<>(creditCardService.create(data), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<CreditCardDto> update(@PathVariable long id, @RequestBody @Valid CreditCardDto data) {
        log.info("Update person.");
        return ResponseEntity.ok().body(creditCardService.update(id, data));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Long> deleteById(@PathVariable long id) {
        log.info("Get person by id.");
        return ResponseEntity.ok().body(creditCardService.deleteById(id));
    }
}
