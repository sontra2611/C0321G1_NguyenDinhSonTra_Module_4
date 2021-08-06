package com.codegym.model.repository.service;

import com.codegym.model.entity.service.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceTypeRepository extends JpaRepository<ServiceType, Integer> {
}
