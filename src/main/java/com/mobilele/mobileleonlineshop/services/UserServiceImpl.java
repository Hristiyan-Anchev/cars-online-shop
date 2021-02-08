package com.mobilele.mobileleonlineshop.services;

import com.mobilele.mobileleonlineshop.entities.domain.User;
import com.mobilele.mobileleonlineshop.entities.domain.UserRole;
import com.mobilele.mobileleonlineshop.repositories.UserRepository;
import com.mobilele.mobileleonlineshop.services.Interfaces.UserRoleService;
import com.mobilele.mobileleonlineshop.services.Interfaces.UserService;
import com.mobilele.mobileleonlineshop.web.models.UserRegisterModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@FieldDefaults(level = AccessLevel.PRIVATE)

public class UserServiceImpl implements UserService {
    ModelMapper modelMapper;
    BCryptPasswordEncoder encoder;

    UserRepository userRepository;
    UserRoleService userRoleService;

    @Override
    public User registerUser(UserRegisterModel user) {

        User newUser = modelMapper.map(user, User.class);
        UserRole userRole = userRoleService.getNonAdminRoles().stream()
                .filter(r -> {
                    System.out.printf("debug :: %s ",r.toString());;
                    return r.getRole().toString().equals("ROLE_USER");
                })
                .collect(Collectors.toList()).get(0);
        newUser.setRole(userRole);
        newUser.setIsActive(true);
        newUser.setPassword(encoder.encode(newUser.getPassword()));

        try {
            userRepository.saveAndFlush(newUser);
        } catch (Exception e) {
            System.out.println(e.getMessage() + " caught!!!");

        }


        return newUser;
    }

    @Override
    public Boolean userExists(String user){

        return userRepository.findByUsername(user) != null;
    }



}
