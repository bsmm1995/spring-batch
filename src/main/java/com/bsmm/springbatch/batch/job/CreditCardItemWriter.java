package com.bsmm.springbatch.batch.job;

import com.bsmm.springbatch.domain.CreditCardRisk;
import com.bsmm.springbatch.repository.CreditCardRiskRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CreditCardItemWriter implements ItemWriter<CreditCardRisk> {

    @Autowired
    private CreditCardRiskRepository repository;

    @Override
    public void write(List<? extends CreditCardRisk> list) throws Exception {
        repository.saveAll(list);
    }
}
