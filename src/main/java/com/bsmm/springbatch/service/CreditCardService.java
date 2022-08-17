package com.bsmm.springbatch.service;

import com.bsmm.springbatch.domain.CreditCardDto;

import java.util.List;

public interface CreditCardService {
    CreditCardDto getById(long id);

    List<CreditCardDto> getAll();

    CreditCardDto create(CreditCardDto data);

    CreditCardDto update(long id, CreditCardDto data);

    long deleteById(long id);
}
