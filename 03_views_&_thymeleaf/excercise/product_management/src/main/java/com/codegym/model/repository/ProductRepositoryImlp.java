package com.codegym.model.repository;

import com.codegym.model.bean.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepositoryImlp implements ProductRepository {
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "Iphone", "30000000", "This is Iphone", "Apple"));
        productMap.put(2, new Product(2, "Samsung", "20000000", "This is Samsung", "Samsung"));
        productMap.put(3, new Product(3, "Nokia", "10000000", "This is Nokia", "Nokia"));
        productMap.put(4, new Product(4, "Sony", "5000000", "This is Sony", "sony"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        Product product = null;
        Set<Integer> set = productMap.keySet();
        for (Integer key : set) {
            if ((productMap.get(key).getNameProduct().toLowerCase()).equals(name.toLowerCase())) {
                product = productMap.get(key);
                productList.add(product);
            }
        }
        return productList;
    }
}
