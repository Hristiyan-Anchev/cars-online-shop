package com.mobilele.mobileleonlineshop.web.controllers;

import com.mobilele.mobileleonlineshop.dtos.view.models.OfferPreviewDTO;
import com.mobilele.mobileleonlineshop.dtos.view.models.OfferUploadDTO;
import com.mobilele.mobileleonlineshop.entities.domain.Offer;
import com.mobilele.mobileleonlineshop.entities.domain.User;
import com.mobilele.mobileleonlineshop.entities.enums.Engine;
import com.mobilele.mobileleonlineshop.entities.enums.Transmission;
import com.mobilele.mobileleonlineshop.repositories.ModelRepository;
import com.mobilele.mobileleonlineshop.repositories.OfferRepository;
import com.mobilele.mobileleonlineshop.repositories.UserRepository;
import com.mobilele.mobileleonlineshop.services.Interfaces.BrandService;
import com.mobilele.mobileleonlineshop.services.Interfaces.OfferService;
import com.mobilele.mobileleonlineshop.services.Interfaces.UserService;
import com.mobilele.mobileleonlineshop.services.ModelServiceImpl;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@FieldDefaults(level = AccessLevel.PRIVATE)
@Controller
@RequestMapping("/offers")
public class OffersController {


    ModelMapper modelMapper;
    BrandService brandService;
    UserRepository userRepository;
    ModelRepository modelRepository;
    OfferService offerService;

    @GetMapping("/all")
    public String getAllOffers(Model model){
        List<OfferPreviewDTO> allOffers = offerService.getAllOffers();

        model.addAttribute("offers",allOffers);
        return "offers";
    }


    @GetMapping("/add")
    public String addOfferView(Model model){
        if(!model.containsAttribute("offer")){
            OfferUploadDTO offer = new OfferUploadDTO(
                  "",
                    "",
                    "",
                    0,
                    .0,
                    "",
                    1,
                    "",
                    Engine.values(),
                    Transmission.values(),
                    brandService.findAllBrands()
            );

            model.addAttribute("offer",offer);
        }else{
            OfferUploadDTO offer = (OfferUploadDTO)model.getAttribute("offer");
            offer.setEngineOptions(Engine.values());
            offer.setTransmissionOptions(Transmission.values());
            offer.setBrands(brandService.findAllBrands());
        }

        return "offer-add";
    }


    @PostMapping("/add")
    public String addOffer(@Valid @ModelAttribute OfferUploadDTO offer,BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           Principal principal
                           ){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("offer",offer);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.offer"
                    ,bindingResult);

            return "redirect:/offers/add";
        }


        Offer newOffer = modelMapper.map(offer,Offer.class);

        User currentSeller = userRepository.findByUsername(principal.getName());
        com.mobilele.mobileleonlineshop.entities.domain.Model currentModel =
                modelRepository.findByName(offer.getModel());

        newOffer.setSeller(currentSeller);
        newOffer.setModel(currentModel);

        offerService.addOffer(newOffer);

        return "redirect:/offers/all";
    }

    @GetMapping("/details")
    public String getOfferDetails(Model model, @RequestParam(name = "cid") Long cid){
        OfferPreviewDTO targetOffer  =  offerService.findById(cid);

        model.addAttribute("offer",targetOffer);

        return "details";
    }


    @GetMapping("/delete")
    public String deleteOffer(Model model, @RequestParam(name = "cid") Long cid){
        offerService.deleteOne(cid);

        return "redirect:/offers/all";
    }

    @GetMapping("/update")
    public String getUpdateView(Model model,@RequestParam(name="cid") Long offerId){
        model.addAttribute("offerId",offerId);

        if (!model.containsAttribute("offer")){
            OfferPreviewDTO targetOffer = offerService.findById(offerId);

            model.addAttribute("offer",new OfferUploadDTO(
                    targetOffer.getDescription(),
                    targetOffer.getEngine(),
                    targetOffer.getImageUrl(),
                    targetOffer.getMileage(),
                    targetOffer.getPrice(),
                    targetOffer.getTransmission(),
                    targetOffer.getYear(),
                    targetOffer.getModelName()
                    ,Engine.values(),
                    Transmission.values(),
                    brandService.findAllBrands()
            ));
        }else{
            OfferUploadDTO offer =(OfferUploadDTO) model.getAttribute("offer");
            offer.setEngineOptions(Engine.values());
            offer.setTransmissionOptions(Transmission.values());
            offer.setBrands(brandService.findAllBrands());
        }

        return "update";
    }

    @PostMapping("/update")
    public String updateOffer(@Valid @ModelAttribute OfferUploadDTO offer,BindingResult bindingResult,RedirectAttributes redirectAttributes,
                            @RequestParam("cid") Long offerId  ){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("offer",offer);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offer",bindingResult);
            return String.format("redirect:/offers/update?cid=%d",offerId);
        }

        offerService.updateOffer(
                offer.getDescription(),
                Engine.valueOf(offer.getEngine()),
                offer.getImageUrl(),
                offer.getMileage(),
                offer.getPrice(),
                Transmission.valueOf(offer.getTransmission()),
                offer.getYear(),
                modelRepository.findByName(offer.getModel())
        );

    //todo: finish template
        return "redirect:/offers/all";
    }


}

