package com.mobilele.mobileleonlineshop.misc.validators;

import com.mobilele.mobileleonlineshop.misc.validators.annotations.EnforceUserRole;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnforceUserRoleValidator implements
        ConstraintValidator<EnforceUserRole,String> {
    @Override
    public void initialize(EnforceUserRole constraintAnnotation) {

    }

    @Override
    public boolean isValid(String role, ConstraintValidatorContext context) {
        return role.equals("USER");
    }
}
