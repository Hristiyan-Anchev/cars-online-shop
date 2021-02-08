package com.mobilele.mobileleonlineshop.entities.domain;

import com.mobilele.mobileleonlineshop.entities.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
@Table
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class User extends BaseEntity {
    @Column(unique = true)
    @NotNull
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

    @ManyToOne(fetch = FetchType.EAGER)
    UserRole role;

    @OneToMany(mappedBy = "seller", targetEntity = Offer.class, fetch = FetchType.EAGER)
    Set<Offer> offers;

}
