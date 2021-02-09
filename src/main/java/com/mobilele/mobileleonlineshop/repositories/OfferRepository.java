package com.mobilele.mobileleonlineshop.repositories;

import com.mobilele.mobileleonlineshop.entities.domain.Model;
import com.mobilele.mobileleonlineshop.entities.domain.Offer;
import com.mobilele.mobileleonlineshop.entities.enums.Engine;
import com.mobilele.mobileleonlineshop.entities.enums.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Offer o SET o.description = ?1, o.engine = ?2, o.imageUrl = ?3, o.mileage = ?4, o.price = ?5, o.transmission = ?6, o.year = ?7, o.model = ?8")
    public void updateOffer(String description, Engine engine, String imageUrl, Integer mileage, Double price, Transmission transmission, Integer year, Model model);




}
