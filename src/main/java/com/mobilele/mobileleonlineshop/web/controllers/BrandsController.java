package com.mobilele.mobileleonlineshop.web.controllers;

import com.mobilele.mobileleonlineshop.dtos.view.models.BrandDTO;
import com.mobilele.mobileleonlineshop.services.Interfaces.BrandService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/brands")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BrandsController {
    BrandService brandService;


    @GetMapping("/all")
    public String getAllBrands(Model model){
        List<BrandDTO> allBrands = brandService.findAllBrands();
        model.addAttribute("hasBrands",allBrands.size() > 0);
        model.addAttribute("brands",allBrands);
        model.addAttribute("carNum",1);



        return "brands";
    }


}
