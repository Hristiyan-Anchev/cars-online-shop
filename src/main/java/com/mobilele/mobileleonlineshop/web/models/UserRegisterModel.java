package com.mobilele.mobileleonlineshop.web.models;

import com.mobilele.mobileleonlineshop.misc.validators.annotations.EnforceUserRole;
import com.mobilele.mobileleonlineshop.misc.validators.annotations.UniqueUsername;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Validated
public class UserRegisterModel {


    @NotEmpty(message = "First name is required")
    @Length(min=2,max=20, message = "Length must be between 2 and 20 symbols")
    String firstName;

    @NotNull
    @NotEmpty(message = "Last name is required")
    @Length(min=2,max=20, message = "Length must be between 2 and 20 symbols")
    String lastName;

    @NotNull
    @NotEmpty(message = "Username is required")
    @Length(min=2,max=20, message = "Length must be between 2 and 20 symbols")
    @UniqueUsername
    String username;

    @NotNull
    @NotEmpty(message = "Password is required")
    @Length(min=2,max=20, message = "Length must be between 2 and 20 symbols")
    String password;


    @NotEmpty(message = "Role is required")
    @Pattern(regexp = "USER",message = "You can only register users!")
    @EnforceUserRole
    String role;

}
