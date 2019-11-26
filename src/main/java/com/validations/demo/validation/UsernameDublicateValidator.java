package com.validations.demo.validation;

import com.validations.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameDublicateValidator implements ConstraintValidator<UniqueSchoolNumber, Integer> {

   @Autowired
   StudentRepository studentRepository;

   public boolean isValid(Integer value, ConstraintValidatorContext context) {

      if (studentRepository.findByNumber(value) == null){
         return true;
      }

      return false;
   }
}
