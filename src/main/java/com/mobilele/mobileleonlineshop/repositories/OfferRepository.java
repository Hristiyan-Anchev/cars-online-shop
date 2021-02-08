package com.mobilele.mobileleonlineshop.repositories;

import com.mobilele.mobileleonlineshop.entities.domain.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {



}
