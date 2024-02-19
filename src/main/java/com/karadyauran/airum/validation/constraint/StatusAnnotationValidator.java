package com.karadyauran.airum.validation.constraint;

import com.karadyauran.airum.entity.enums.TaskStatus;
import com.karadyauran.airum.validation.interf.StatusValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StatusAnnotationValidator implements ConstraintValidator<StatusValidator, String>
{

    @Override
    public void initialize(StatusValidator constraintAnnotation)
    {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext)
    {
        var fields = TaskStatus.values();
        for (TaskStatus field : fields)
        {
            if (field.name().equals(s)) return true;
        }
        return false;
    }
}
