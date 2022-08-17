package com.bsmm.springbatch.service;

import com.bsmm.springbatch.domain.dto.CreditCardRiskDto;

import java.util.List;

public interface CreditCardRiskService {
    CreditCardRiskDto getById(long id);

    List<CreditCardRiskDto> getAll();

    CreditCardRiskDto create(CreditCardRiskDto data);

    CreditCardRiskDto update(long id, CreditCardRiskDto data);

    long deleteById(long id);
}
