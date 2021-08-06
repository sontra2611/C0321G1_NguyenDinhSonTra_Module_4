package com.codegym.model.repository.service;

import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceRepository extends JpaRepository<Service, Integer> {
    Page<Service> findAllByServiceNameContaining(Pageable pageable, String name);
}
