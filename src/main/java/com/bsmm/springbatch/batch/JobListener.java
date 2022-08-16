package com.bsmm.springbatch.batch;

import com.bsmm.springbatch.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JobListener extends JobExecutionListenerSupport {
    private static final Logger LOG = LoggerFactory.getLogger(JobListener.class);
    private final PersonRepository personRepository;

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            personRepository.findAll().forEach(System.out::println);
            LOG.info("FINALIZÓ EL JOB!! Verifica los resultados:");
        }
    }

}
