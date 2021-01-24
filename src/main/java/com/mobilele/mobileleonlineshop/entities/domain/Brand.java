package com.mobilele.mobileleonlineshop.entities.domain;

import com.mobilele.mobileleonlineshop.entities.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@Autowired))
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Brand extends BaseEntity {

    @Column
    String name;

    @OneToMany(mappedBy = "brand", targetEntity = Model.class,fetch = FetchType.EAGER)
    Set<Model> models;

}
