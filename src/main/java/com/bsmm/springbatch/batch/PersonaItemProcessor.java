package com.bsmm.springbatch.batch;

import com.bsmm.springbatch.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class PersonaItemProcessor implements ItemProcessor<Person, Person> {
    @Override
    public Person process(Person item) {
        String firstName = item.getFirstName().toUpperCase();
        String lastName = item.getLastName().toUpperCase();
        String phone = item.getPhone();

        Person person = new Person(firstName, lastName, phone);

        log.info("Convirtiendo (" + item + ") a (" + person + ")");
        return person;
    }
}
