package com.mobilele.mobileleonlineshop.misc.validators.annotations;

import com.mobilele.mobileleonlineshop.misc.validators.EnforceUserRoleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EnforceUserRoleValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnforceUserRole {

    String message() default "The role must be USER";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
