package com.bsmm.springbatch.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String firstName;
    private String lastName;
    private String phone;

    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + "]";
    }
}
