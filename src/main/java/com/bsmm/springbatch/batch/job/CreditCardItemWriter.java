package com.bsmm.springbatch.batch.job;

import com.bsmm.springbatch.domain.entities.CreditCardRiskEntity;
import com.bsmm.springbatch.repository.CreditCardRiskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class CreditCardItemWriter implements ItemWriter<CreditCardRiskEntity> {

    @Autowired
    private CreditCardRiskRepository repository;

    @Override
    public void write(List<? extends CreditCardRiskEntity> list) {
        repository.saveAll(list);
    }
}
