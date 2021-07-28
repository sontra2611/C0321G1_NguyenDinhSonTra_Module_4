package com.codegym.model.repository;

import com.codegym.model.bean.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepository  extends PagingAndSortingRepository<Product, Long> {
}
