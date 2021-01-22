package com.mobilele.mobileleonlineshop.entities.domain;

import com.mobilele.mobileleonlineshop.entities.BaseEntity;
import com.mobilele.mobileleonlineshop.entities.domain.Model;
import com.mobilele.mobileleonlineshop.entities.enums.Engine;
import com.mobilele.mobileleonlineshop.entities.enums.Transmission;
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
public class Offer extends BaseEntity {
    @Column
    String description;

    @Column
    @Enumerated(EnumType.ORDINAL)
    Engine engine;

    @Column
    String imageUrl;

    @Column
    Integer mileage;

    @Column
    Double price;

    @Column
    @Enumerated(EnumType.ORDINAL)
    Transmission transmission;

    @Column
    Integer year;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    Model model;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    User seller;

}
