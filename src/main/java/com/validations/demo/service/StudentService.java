package com.validations.demo.service;

import com.validations.demo.model.Student;
import com.validations.demo.repository.StudentRepository;
import com.validations.demo.shared.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public GenericResponse save(Student student){
        studentRepository.save(student);
        return new GenericResponse( student.getName() +" has been saved.");
    }

    public Page<Student> pageableUsers(Pageable pageable){
        return studentRepository.findAll(pageable);
    }
}
