package com.bsmm.springbatch.service;

import com.bsmm.springbatch.domain.PersonDto;

import java.util.List;

public interface PersonService {
    PersonDto getById(long id);

    List<PersonDto> getAll();

    PersonDto create(PersonDto data);

    PersonDto update(long id, PersonDto data);

    long deleteById(long id);
}
