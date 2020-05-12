package com.ykb.cloud.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyCustomValidation implements ConstraintValidator<MyValid, String> {

    private MyValid constraintAnnotation;

    @Override
    public void initialize(final MyValid constraintAnnotationParam) {
        this.constraintAnnotation = constraintAnnotationParam;

    }

    @Override
    public boolean isValid(final String valueParam,
                           final ConstraintValidatorContext contextParam) {
        if ((valueParam.length() > this.constraintAnnotation.min())
            && (valueParam.length() < this.constraintAnnotation.max())) {
            return true;
        }
        return false;
    }

}
