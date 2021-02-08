package com.mobilele.mobileleonlineshop.dtos.view.models;

import com.mobilele.mobileleonlineshop.entities.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor()
@NoArgsConstructor()
@Builder
public class ModelDTO {

    String name;
    Category category;
    String imageUrl;
    Integer startYear;
    Integer endYear;



}
