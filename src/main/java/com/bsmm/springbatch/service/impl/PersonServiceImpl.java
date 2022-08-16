package com.bsmm.springbatch.service.impl;

import com.bsmm.springbatch.domain.PersonDto;
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
    public PersonDto getById(long id) {
        return toDto(getEntity(id));
    }

    @Override
    public List<PersonDto> getAll() {
        return personRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public PersonDto create(PersonDto data) {
        PersonEntity person = personRepository.save(toEntity(data));
        return toDto(person);
    }

    @Override
    public PersonDto update(long id, PersonDto data) {
        PersonEntity person = getEntity(id);
        person.setName(data.getName());
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

    private PersonDto toDto(PersonEntity entity) {
        return modelMapper.map(entity, PersonDto.class);
    }

    private PersonEntity toEntity(PersonDto dto) {
        return modelMapper.map(dto, PersonEntity.class);
    }

}
