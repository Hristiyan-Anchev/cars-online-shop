package com.mobilele.mobileleonlineshop.entities.domain;

import com.mobilele.mobileleonlineshop.entities.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Brand extends BaseEntity {

    @Column
    String name;

    @OneToMany(mappedBy = "brand", targetEntity = Model.class)
    Set<Model> models;

}
