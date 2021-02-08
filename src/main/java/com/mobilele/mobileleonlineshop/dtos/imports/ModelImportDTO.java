package com.mobilele.mobileleonlineshop.dtos.imports;

import com.mobilele.mobileleonlineshop.entities.enums.Category;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ModelImportDTO {
    String name;
    Category category;
    String imageUrl;
    Integer startYear;
    Integer endYear;
    Integer brandId;

}
