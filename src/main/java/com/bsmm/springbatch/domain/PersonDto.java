package com.bsmm.springbatch.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private long id;
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotBlank
    private String phone;

    public PersonDto(String name, String lastName, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "PersonDto [firstName=" + name + ", lastName=" + lastName + ", phone=" + phone + "]";
    }
}
