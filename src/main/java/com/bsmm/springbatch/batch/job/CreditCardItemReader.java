package com.bsmm.springbatch.batch.job;

import com.bsmm.springbatch.domain.entities.CreditCardEntity;
import com.bsmm.springbatch.repository.CreditCardRepository;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;

public class CreditCardItemReader implements ItemReader<CreditCardEntity> {

    @Autowired
    private CreditCardRepository repository;

    private Iterator<CreditCardEntity> usersIterator;

    @BeforeStep
    public void before(StepExecution stepExecution) {
        usersIterator = repository.findAll().iterator();
    }

    @Override
    public CreditCardEntity read() {
        if (usersIterator != null && usersIterator.hasNext()) {
            return usersIterator.next();
        } else {
            return null;
        }
    }
}
