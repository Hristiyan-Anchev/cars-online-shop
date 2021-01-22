package com.mobilele.mobileleonlineshop.repositories;

import com.mobilele.mobileleonlineshop.entities.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}

