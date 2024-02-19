package com.karadyauran.airum.validation.interf;

import com.karadyauran.airum.validation.constraint.StatusAnnotationValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.PARAMETER, ElementType.FIELD })
@Constraint(validatedBy = { StatusAnnotationValidator.class })
public @interface StatusValidator
{
    String message() default "It`s not a STATUS";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
