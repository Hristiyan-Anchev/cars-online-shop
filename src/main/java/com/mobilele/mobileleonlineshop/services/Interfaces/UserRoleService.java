package com.mobilele.mobileleonlineshop.services.Interfaces;


import com.mobilele.mobileleonlineshop.entities.domain.UserRole;

import java.util.List;
import java.util.Set;

public interface UserRoleService {
    List<UserRole> getAllRoles();
    public List<UserRole> getNonAdminRoles();
}
