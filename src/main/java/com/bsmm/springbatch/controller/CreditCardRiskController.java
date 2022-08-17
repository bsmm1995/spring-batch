package com.bsmm.springbatch.controller;

import com.bsmm.springbatch.domain.dto.CreditCardRiskDto;
import com.bsmm.springbatch.service.CreditCardRiskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/credit-cards-risk")
@RequiredArgsConstructor
@Slf4j
public class CreditCardRiskController {
    private final CreditCardRiskService creditCardRiskService;

    @GetMapping
    ResponseEntity<List<CreditCardRiskDto>> getAll() {
        log.info("Get all persons.");
        return ResponseEntity.ok().body(creditCardRiskService.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<CreditCardRiskDto> getById(@PathVariable long id) {
        log.info("Get person by id.");
        return ResponseEntity.ok().body(creditCardRiskService.getById(id));
    }

    @PostMapping
    ResponseEntity<CreditCardRiskDto> create(@RequestBody @Valid CreditCardRiskDto data) {
        log.info("Create person.");
        return new ResponseEntity<>(creditCardRiskService.create(data), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<CreditCardRiskDto> update(@PathVariable long id, @RequestBody @Valid CreditCardRiskDto data) {
        log.info("Update person.");
        return ResponseEntity.ok().body(creditCardRiskService.update(id, data));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Long> deleteById(@PathVariable long id) {
        log.info("Get person by id.");
        return ResponseEntity.ok().body(creditCardRiskService.deleteById(id));
    }
}
