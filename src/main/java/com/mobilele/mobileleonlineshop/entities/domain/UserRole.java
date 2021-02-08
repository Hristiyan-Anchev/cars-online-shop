package com.mobilele.mobileleonlineshop.entities.domain;

import com.mobilele.mobileleonlineshop.entities.BaseEntity;
import com.mobilele.mobileleonlineshop.entities.enums.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRole extends BaseEntity implements GrantedAuthority {
    @Column
    @Enumerated(EnumType.STRING)
    Role role;

    @Override
    public String getAuthority() {
        return role.name().toString();
    }

//    @OneToMany()
//    Set<User> users;



}
