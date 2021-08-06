package com.codegym.model.service.customer;

import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Iterator;
import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(Integer id);

    void removeById(Integer id);

    Page<Customer> searchByName(Pageable pageable, String name);

    List<CustomerType> findAllCustomerType();
}
