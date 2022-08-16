package com.bsmm.springbatch.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String lastName;
    private String phone;

    public PersonEntity(String name, String lastName, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "PersonDto [id= " + id + ", firstName=" + name + ", lastName=" + lastName + ", phone=" + phone + "]";
    }
}
