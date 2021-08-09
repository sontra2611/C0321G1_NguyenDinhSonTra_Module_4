package com.codegym.model.repository.customer;

import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Iterator;
import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value ="select * from customer where customer.customer_name like %?1% and flag = false", nativeQuery = true)
    Page<Customer> findAllByCustomerNameContaining(Pageable pageable, String name);
}
