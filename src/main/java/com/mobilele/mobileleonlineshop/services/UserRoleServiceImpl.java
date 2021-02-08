package com.mobilele.mobileleonlineshop.services;

import com.mobilele.mobileleonlineshop.entities.domain.UserRole;
import com.mobilele.mobileleonlineshop.entities.enums.Role;
import com.mobilele.mobileleonlineshop.repositories.UserRoleRepository;
import com.mobilele.mobileleonlineshop.services.Interfaces.UserRoleService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@FieldDefaults(level = AccessLevel.PRIVATE)

public class UserRoleServiceImpl implements UserRoleService {

    UserRoleRepository userRoleRepository;

    @Override
    public List<UserRole> getAllRoles() {
       return  userRoleRepository.findAll();
    }

    public List<UserRole> getNonAdminRoles(){

        List<UserRole> allByRole = userRoleRepository.findAllByRole(Role.ROLE_USER);
        return allByRole;
    }
}
