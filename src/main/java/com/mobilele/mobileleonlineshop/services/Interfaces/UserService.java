package com.mobilele.mobileleonlineshop.services.Interfaces;

import com.mobilele.mobileleonlineshop.entities.domain.User;
import com.mobilele.mobileleonlineshop.web.models.UserRegisterModel;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;

public interface UserService {

    User registerUser( UserRegisterModel user);
    Boolean userExists(String user);

}
