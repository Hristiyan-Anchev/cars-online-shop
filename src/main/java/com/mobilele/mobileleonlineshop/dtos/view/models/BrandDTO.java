package com.mobilele.mobileleonlineshop.dtos.view.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@AllArgsConstructor()
@NoArgsConstructor()
@Builder
public class BrandDTO {

    String name;
    Set<ModelDTO> models;

}
