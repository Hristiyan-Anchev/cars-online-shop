package com.mobilele.mobileleonlineshop.repositories;

import com.mobilele.mobileleonlineshop.entities.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Long> {
}
