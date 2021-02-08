package com.mobilele.mobileleonlineshop.misc.validators.validation.classes;


import com.mobilele.mobileleonlineshop.misc.validators.annotations.UniqueUsername;
import com.mobilele.mobileleonlineshop.services.Interfaces.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class UniqueUserValidator implements
        ConstraintValidator<UniqueUsername,String> {

    UserService userService;

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {

    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return !userService.userExists(username);
    }
}
