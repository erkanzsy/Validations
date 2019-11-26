package com.validations.demo.model;

import com.validations.demo.validation.UniqueSchoolNumber;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue
    private long id;

    @UniqueSchoolNumber
    private int number;

    @NotNull
    @Size(min = 3,max = 255)
    private String name;

    @NotNull
    @Size(min = 2, message = "{javax.validation.constraints.surname.Size.message}")
    private String surname;

    @NotNull
    @Size(min = 4,max = 255)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{org.hibernate.validator.key.pattern.message}")
    private String key;

    public Student(int number, String name, String surname, String key) {
        this.number = number;
        this.name = name;
        this.surname = surname;
        this.key = key;
    }
}
