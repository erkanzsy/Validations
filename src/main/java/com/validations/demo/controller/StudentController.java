package com.validations.demo.controller;

import com.validations.demo.error.ApiError;
import com.validations.demo.model.Student;
import com.validations.demo.service.StudentService;
import com.validations.demo.shared.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public GenericResponse save(@Valid @RequestBody Student student){
        return studentService.save(student);
    }

    @GetMapping("/students")
    public Page<Student> users(Pageable pageable){
        return studentService.pageableUsers(pageable);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleValidationException(MethodArgumentNotValidException exception, HttpServletRequest request){
        ApiError apiError = new ApiError(400,"Validation error",request.getServletPath());

        BindingResult bindingResult = exception.getBindingResult();

        Map<String, String> validationErrors = new HashMap<>();

        for (FieldError fieldError: bindingResult.getFieldErrors()) {
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }

        apiError.setValidationErrors(validationErrors);

        return apiError;
    }
}
