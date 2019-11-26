package com.validations.demo.repository;

import com.validations.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByNumber(int number);
}
