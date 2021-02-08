package com.mobilele.mobileleonlineshop.services;


import com.google.gson.reflect.TypeToken;
import com.mobilele.mobileleonlineshop.dtos.view.models.OfferPreviewDTO;
import com.mobilele.mobileleonlineshop.entities.domain.Offer;
import com.mobilele.mobileleonlineshop.repositories.OfferRepository;
import com.mobilele.mobileleonlineshop.services.Interfaces.OfferService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Service
public class OfferServiceImpl implements OfferService {

    OfferRepository offerRepository;
    ModelMapper modelMapper;

    @Override
    public void addOffer(Offer offer){
        offerRepository.saveAndFlush(offer);
    }

    @Override
    public List<OfferPreviewDTO> getAllOffers() {
        var allOffers = offerRepository.findAll();

        return modelMapper.map(allOffers,
                new TypeToken<List<OfferPreviewDTO>>(){}.getType());

    }

    @Override
    public OfferPreviewDTO findById(Long id) {
        Offer offer = offerRepository.getOne(id);

        return modelMapper.map(offer,OfferPreviewDTO.class);

    }

    @Override
    public void deleteOne(Long id) {
    offerRepository.deleteById(id);
    }


}
