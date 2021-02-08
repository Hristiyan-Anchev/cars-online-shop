package com.mobilele.mobileleonlineshop.services;

import com.google.gson.reflect.TypeToken;
import com.mobilele.mobileleonlineshop.dtos.view.models.BrandDTO;
import com.mobilele.mobileleonlineshop.entities.domain.Brand;
import com.mobilele.mobileleonlineshop.repositories.BrandRepository;
import com.mobilele.mobileleonlineshop.services.Interfaces.BrandService;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data()
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@Autowired))
@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
public class BrandServiceImpl implements BrandService {

    BrandRepository brandRepository;
    ModelMapper modelMapper;

    @Override
    public List<BrandDTO> findAllBrands() {
        List<BrandDTO>  brands =  modelMapper.map(brandRepository.findAll()
                ,new TypeToken<List<BrandDTO>>(){}.getType());

        return  brands;
    }

}
