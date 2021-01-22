package com.mobilele.mobileleonlineshop.entities.domain;

import com.mobilele.mobileleonlineshop.entities.BaseEntity;
import com.mobilele.mobileleonlineshop.entities.enums.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRole extends BaseEntity {
    @Column
    @Enumerated(EnumType.ORDINAL)
    Role role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;
}
