package com.mobilele.mobileleonlineshop.services.Interfaces;


import com.mobilele.mobileleonlineshop.dtos.view.models.OfferPreviewDTO;
import com.mobilele.mobileleonlineshop.entities.domain.Offer;

import java.util.List;

public interface OfferService {

    public void addOffer(Offer offer);

    public List<OfferPreviewDTO> getAllOffers();

    public OfferPreviewDTO findById(Long id);

    public void deleteOne(Long id);


}
