package com.mobilele.mobileleonlineshop.services.Interfaces;

import com.mobilele.mobileleonlineshop.dtos.view.models.BrandDTO;


import java.util.List;


public interface BrandService {
    List<BrandDTO> findAllBrands();
}
