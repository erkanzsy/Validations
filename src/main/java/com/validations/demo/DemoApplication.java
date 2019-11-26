package com.validations.demo;

import com.validations.demo.model.Student;
import com.validations.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private StudentRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Student(1212,"Ali","Ahmet","Ali4a"));
        repository.save(new Student(1213,"Jack","Jones","JJ0nes"));
        repository.save(new Student(1214,"Elon","Musk","3Lon"));
        repository.save(new Student(1215,"Steve","Jobs","4pple"));
    }
}
