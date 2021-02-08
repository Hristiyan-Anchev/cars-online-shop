package com.mobilele.mobileleonlineshop.dtos.imports;

import com.mobilele.mobileleonlineshop.entities.enums.Engine;
import com.mobilele.mobileleonlineshop.entities.enums.Transmission;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor()
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OfferImportDTO {

    String description;
    Engine engine;
    String imageUrl;
    Integer mileage;
    Double price;
    Transmission transmission;
    Integer year;
    Long modelId;
    Long sellerId;
}
