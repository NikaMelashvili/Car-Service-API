package com.exam.nikolozmelashvili.validation;

import com.exam.nikolozmelashvili.entities.base.RecordState;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RecordStateValidator implements ConstraintValidator<ValidRecordState, Integer> {

    @Override
    public void initialize(ValidRecordState constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        for (RecordState state : RecordState.values()) {
            if (state.getValue() == value) {
                return true;
            }
        }

        return false;
    }
}
