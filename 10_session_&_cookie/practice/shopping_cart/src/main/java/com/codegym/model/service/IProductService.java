package com.codegym.model.service;

import com.codegym.model.bean.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
