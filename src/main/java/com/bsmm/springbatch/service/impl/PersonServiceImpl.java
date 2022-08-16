package com.bsmm.springbatch.service.impl;

import com.bsmm.springbatch.domain.Person;
import com.bsmm.springbatch.domain.PersonEntity;
import com.bsmm.springbatch.repository.PersonRepository;
import com.bsmm.springbatch.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    @Override
    public Person getById(long id) {
        return toDto(getEntity(id));
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public Person create(Person data) {
        PersonEntity person = personRepository.save(toEntity(data));
        return toDto(person);
    }

    @Override
    public Person update(long id, Person data) {
        PersonEntity person = getEntity(id);
        person.setFirstName(data.getFirstName());
        person.setLastName(data.getLastName());
        person.setPhone(data.getPhone());
        return toDto(personRepository.save(person));
    }

    @Override
    public long deleteById(long id) {
        getEntity(id);
        personRepository.deleteById(id);
        return id;
    }

    private PersonEntity getEntity(long id) {
        return personRepository.findById(id).orElseThrow(() -> new NotFoundException("The person with ID %d not exists."));
    }

    private Person toDto(PersonEntity entity) {
        return modelMapper.map(entity, Person.class);
    }

    private PersonEntity toEntity(Person dto) {
        return modelMapper.map(dto, PersonEntity.class);
    }

}
