package com.mobilele.mobileleonlineshop.services.Interfaces;


import com.mobilele.mobileleonlineshop.dtos.view.models.OfferPreviewDTO;
import com.mobilele.mobileleonlineshop.entities.domain.Model;
import com.mobilele.mobileleonlineshop.entities.domain.Offer;
import com.mobilele.mobileleonlineshop.entities.enums.Engine;
import com.mobilele.mobileleonlineshop.entities.enums.Transmission;

import java.util.List;

public interface OfferService {

    public void addOffer(Offer offer);

    public List<OfferPreviewDTO> getAllOffers();

    public OfferPreviewDTO findById(Long id);

    public void deleteOne(Long id);

    void updateOffer(String description, Engine engine, String imageUrl, Integer mileage, Double price, Transmission transmission, Integer year, Model model);


}
