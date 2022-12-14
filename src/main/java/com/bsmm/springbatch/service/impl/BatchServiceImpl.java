package com.bsmm.springbatch.service.impl;

import com.bsmm.springbatch.service.BatchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BatchServiceImpl implements BatchService {
    private final JobLauncher jobLauncher;
    private final Job job;

    @Override
    public void startProcess() {
        log.info("Starting the batch job");
        try {
            JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
            jobLauncher.run(job, jobParameters);
            log.info("Job completed");
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Job failed");
        }
    }
}
