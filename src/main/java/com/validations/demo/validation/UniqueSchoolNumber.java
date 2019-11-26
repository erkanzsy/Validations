package com.validations.demo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = UsernameDublicateValidator.class)
@Documented
public @interface UniqueSchoolNumber  {
    String message() default "{org.hibernate.validator.unique.school.number.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
