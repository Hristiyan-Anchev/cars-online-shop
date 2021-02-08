package com.mobilele.mobileleonlineshop.misc.validators.annotations;

import com.mobilele.mobileleonlineshop.misc.validators.EnforceUserRoleValidator;

import javax.validation.Constraint;
import java.lang.annotation.Documented;

@Documented
@Constraint(validatedBy = EnforceUserRoleValidator.class)
public @interface EnforceUser {
}
