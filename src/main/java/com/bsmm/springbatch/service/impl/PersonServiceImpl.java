package com.bsmm.springbatch.service.impl;

import com.bsmm.springbatch.domain.Person;
import com.bsmm.springbatch.domain.PersonEntity;
import com.bsmm.springbatch.repository.PersonRepository;
import com.bsmm.springbatch.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    @Override
    public Person getById(long id) {
        return null;
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public Person create(Person data) {
        return null;
    }

    @Override
    public Person update(long id, Person data) {
        return null;
    }

    @Override
    public long deleteById(long id) {
        return 0;
    }

    private Person toDto(PersonEntity entity) {
        return modelMapper.map(entity, Person.class);
    }
}
