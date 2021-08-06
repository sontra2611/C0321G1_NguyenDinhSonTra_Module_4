package com.codegym.model.repository.service;

import com.codegym.model.entity.service.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepossitory extends JpaRepository<RentType, Integer> {
}
