package com.mobilele.mobileleonlineshop.entities.domain;

import com.mobilele.mobileleonlineshop.entities.BaseEntity;
import com.mobilele.mobileleonlineshop.entities.enums.Category;
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
public class Model  extends BaseEntity {
    @Column
    String name;

    @Column
    @Enumerated(EnumType.STRING)
    Category category;

    @Column
    String imageUrl;

    @Column
    Integer startYear;

    @Column
    Integer endYear;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    Brand brand;

    @OneToMany(mappedBy = "model",targetEntity = Offer.class,fetch = FetchType.EAGER)
    Set<Offer> offers;


}
