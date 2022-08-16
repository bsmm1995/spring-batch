package com.bsmm.springbatch.batch;

import com.bsmm.springbatch.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class PersonaItemProcessor implements ItemProcessor<Person, Person> {
    private static final Logger LOG = LoggerFactory.getLogger(PersonaItemProcessor.class);

    @Override
    public Person process(Person item) {
        String firstName = item.getFirstName().toUpperCase();
        String lastName = item.getLastName().toUpperCase();
        String phone = item.getPhone();

        Person person = new Person(firstName, lastName, phone);

        LOG.info("Convirtiendo (" + item + ") a (" + person + ")");
        return person;
    }
}
