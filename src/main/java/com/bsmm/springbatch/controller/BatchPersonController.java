package com.bsmm.springbatch.controller;

import com.bsmm.springbatch.service.BatchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/batch")
@RequiredArgsConstructor
@Slf4j
public class BatchPersonController {
    private final BatchService batchService;

    @GetMapping("/start")
    ResponseEntity<Void> startProcess(@RequestParam boolean start) {
        if (start) {
            batchService.startProcess();
            log.info("Process started");
        } else {
            log.info("Process not started");
        }
        return ResponseEntity.noContent().build();
    }
}
