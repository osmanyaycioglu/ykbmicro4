package com.ykb.cloud.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Retention(RUNTIME)
@Target({
          FIELD,
          METHOD
})
@Constraint(validatedBy = MyCustomValidation.class)
public @interface MyValid {

    int max();

    int min();

    String message() default "{javax.validation.constraints.MyValid.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
