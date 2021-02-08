package com.mobilele.mobileleonlineshop.dtos.view.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferPreviewDTO {

    Long id;
    String description;
    String engine;
    String imageUrl;
    Integer mileage;
    Double price;
    String transmission;
    Integer year;
    String modelName;
    String modelBrandName;
    String sellerUsername;
    String sellerFirstName;
    String sellerLastName;
    Instant created;
    Instant lastModified;

}
