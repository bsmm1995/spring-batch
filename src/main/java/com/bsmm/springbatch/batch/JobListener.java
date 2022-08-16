package com.bsmm.springbatch.batch;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JobListener extends JobExecutionListenerSupport {
    private static final Logger LOG = LoggerFactory.getLogger(JobListener.class);
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            LOG.info("FINALIZÓ EL JOB!! Verifica los resultados:");

            /*jdbcTemplate
                    .query("SELECT first_name, last_name, phone FROM person",
                            (rs, row) -> new Person(rs.getString(1), rs.getString(2), rs.getString(3)))
                    .forEach(person -> LOG.info("Registro < " + person + " >"));*/
        }
    }

}
