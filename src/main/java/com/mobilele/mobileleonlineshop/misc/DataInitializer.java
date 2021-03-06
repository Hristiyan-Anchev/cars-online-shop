package com.mobilele.mobileleonlineshop.misc;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mobilele.mobileleonlineshop.dtos.imports.*;
import com.mobilele.mobileleonlineshop.entities.domain.*;
import com.mobilele.mobileleonlineshop.entities.enums.Role;
import com.mobilele.mobileleonlineshop.repositories.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DataInitializer implements CommandLineRunner {
    static final String RESOURCE_DIR = "src/main/resources/raw.data/%s";
    BrandRepository brandRepository;
    ModelRepository modelRepository;
    OfferRepository offerRepository;
    UserRepository userRepository;
    UserRoleRepository userRoleRepository;

    TextFileParser textFileParser;
    Gson gson;
    ModelMapper modelMapper;
    ListMapper listMapper;

    @Override
    @SneakyThrows

    public void run(String... args) throws Exception {

        //==================================================================
        //import user roles
        importUserRoles();
        //==================================================================
        // importing brands from JSON
//
        importBrands();
        //==================================================================
        // importing models from JSON

       importModels();

        //==================================================================
        //import userf from JSON
        importUsers();

        //==================================================================
        // importing offers from JSON
        importOffers();




    }


    public void importBrands(){
        if(brandRepository.count() == 0) {
            String brandsFileContent = textFileParser.parseFileAt(String.format(RESOURCE_DIR, "Brands.json"));
            List<BrandImportDTO> brands = gson.fromJson(brandsFileContent, new TypeToken<List<BrandImportDTO>>() {
            }.getType());

            List<Brand> newBrands = listMapper.mapList(brands, Brand.class);
            brandRepository.saveAll(newBrands);
            brandRepository.flush();
        }
    }

    public void importModels(){
        if(modelRepository.count() == 0) {
            String modelsFileContent = textFileParser.parseFileAt(String.format(RESOURCE_DIR, "Models.json"));
            List<ModelImportDTO> importedModels = gson.fromJson(modelsFileContent, new TypeToken<List<ModelImportDTO>>() {
            }.getType());

            List<Model> newModels = importedModels.stream().map(importedModel -> {
                Model newModel = modelMapper.map(importedModel, Model.class);
                Brand targetBrand = brandRepository.findById(Long.valueOf(importedModel.getBrandId())).orElse( null);
                newModel.setBrand(targetBrand);

                return newModel;
            }).collect(Collectors.toList());

            modelRepository.saveAll(newModels);
            modelRepository.flush();
        }
    }

    public void importOffers(){
        if(offerRepository.count() == 0){
            List<OfferImportDTO> importedOffers = gson.fromJson(textFileParser.parseFileAt(String.format(RESOURCE_DIR,"Offers.json"))
                    ,new TypeToken<List<OfferImportDTO>>(){}.getType());

            List<Offer> newOffers = importedOffers.stream().map(importedOffer -> {
                Offer newOffer = modelMapper.map(importedOffer,Offer.class);
                Model targetModel = modelRepository.findById(importedOffer.getModelId()).orElse(null);
                User targetSeller = userRepository.findById(importedOffer.getSellerId()).orElse(null);

                newOffer.setModel(targetModel);
                newOffer.setSeller(targetSeller);

                return newOffer;
            }).collect(Collectors.toList());
            offerRepository.saveAll(newOffers);
        }
    }

    public void importUsers(){
        if(userRepository.count() == 0){

            ArrayDeque<UserRoleImportDTO> userRolesMapping = gson.fromJson(textFileParser.parseFileAt(String.format(RESOURCE_DIR,"UserRoles.json")),
                    new TypeToken<ArrayDeque<UserRoleImportDTO>>(){}.getType());

            List<UserImportDTO> importedUsers = gson.fromJson(textFileParser.parseFileAt(String.format(RESOURCE_DIR,"Users.json")),
                    new TypeToken<List<UserImportDTO>>(){}.getType());

            List<User> newUsers = importedUsers.stream().map(importedUser ->{
                User newUser = modelMapper.map(importedUser,User.class);
                var mappedRole = userRolesMapping.removeFirst().getRole();
                UserRole newUserRole = userRoleRepository.findByRole(mappedRole);
                newUser.setRole(newUserRole);

                return newUser;
            }).collect(Collectors.toList());

            userRepository.saveAll(newUsers);

        }
    }

    public void importUserRoles(){
        if(userRoleRepository.count() == 0) {
            UserRole user = new UserRole();
            user.setRole(Role.ROLE_USER);

            UserRole admin = new UserRole();
            admin.setRole(Role.ROLE_ADMIN);

            userRoleRepository.saveAll(List.of(user,admin));
        }
    }
}
