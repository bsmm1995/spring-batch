package com.bsmm.springbatch.batch;

import com.bsmm.springbatch.domain.Person;
import com.bsmm.springbatch.domain.PersonEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class PersonaItemProcessor implements ItemProcessor<Person, PersonEntity> {
    @Override
    public PersonEntity process(Person item) {
        String firstName = item.getFirstName().toUpperCase();
        String lastName = item.getLastName().toUpperCase();
        String phone = item.getPhone();

        PersonEntity person = new PersonEntity(firstName, lastName, phone);

        log.info("Convert  (" + item + ") to (" + person + ")");
        return person;
    }
}
