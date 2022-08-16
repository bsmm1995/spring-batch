package com.bsmm.springbatch.service;

import com.bsmm.springbatch.domain.Person;

import java.util.List;

public interface PersonService {
    Person getById(long id);

    List<Person> getAll();

    Person create(Person data);

    Person update(long id, Person data);

    long deleteById(long id);
}
