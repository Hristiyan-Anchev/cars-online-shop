package com.mobilele.mobileleonlineshop.entities.domain;

import com.mobilele.mobileleonlineshop.entities.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User extends BaseEntity {
    @Column
    String username;

    @Column
    String password;

    @Column
    String firstName;

    @Column
    String lastName;

    @Column
    Boolean isActive;

    @Column
    String imageUrl;

    @OneToMany(mappedBy = "user",targetEntity = UserRole.class,fetch = FetchType.EAGER)
    Set<UserRole> roles;

    @OneToMany(mappedBy = "seller", targetEntity = Offer.class, fetch = FetchType.EAGER)
    Set<Offer> offers;

}
