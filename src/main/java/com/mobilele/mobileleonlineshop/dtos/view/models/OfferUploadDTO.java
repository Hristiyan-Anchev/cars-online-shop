package com.mobilele.mobileleonlineshop.dtos.view.models;

import com.mobilele.mobileleonlineshop.entities.enums.Engine;
import com.mobilele.mobileleonlineshop.entities.enums.Transmission;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class OfferUploadDTO {
    @NotEmpty(message = "Description is required")
    @Size(min = 1, max = 100)
    String description;

    @NotEmpty(message = "Engine is required")
    String engine;

    @NotEmpty(message = "Image is required")
    @URL(message = "Image is not a valid URL")
    String imageUrl;

    @Positive(message = "Mileage needs to be positive number")
    @NotNull
    Integer mileage;

    @Positive(message = "Price needs to be positive number")
    @NotNull
    Double price;

    @NotEmpty(message = "Transmission is required")
    String transmission;

    @Positive(message = "Year must be positive")
    @NotNull
    @Min(value = 1900,message = "Year must be greater than 1900")
    Integer year;

    @NotEmpty(message = "Model is required")
    String model;


    Engine[] engineOptions;
    Transmission[] transmissionOptions;
    List<BrandDTO> brands;




}
