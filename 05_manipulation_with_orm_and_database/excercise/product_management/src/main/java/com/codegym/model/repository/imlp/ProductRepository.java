package com.codegym.model.repository.imlp;

import com.codegym.model.bean.Product;
import com.codegym.model.repository.IProductRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.*;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        return BaseRepository.entityManager.createQuery(
                "select p " +
                        "from product p", Product.class).getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.persist(product);
        transaction.commit();
    }

    @Override
    public Product findById(int id) {
        return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public void update(int id, Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.merge(product);
        transaction.commit();
    }

    @Override
    public void remove(int id) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        Product product = findById(id);
        BaseRepository.entityManager.remove(product);
        transaction.commit();
    }

    @Override
    public List<Product> findByName(String name) {
        String queryStr = "select p from product p where p.nameProduct like :name";
        Query query = BaseRepository.entityManager.createQuery(queryStr, Product.class);
        query.setParameter("name","%" + name + "%");
        return query.getResultList();
//        Session session = null;
//        List<Product> productList = null;
//        String query = "select p from product p where p.nameProduct like :name";
//        try {
//            session = BaseRepository.sessionFactory.openSession();
//            Query query1 = session.createQuery(query, Product.class);
//            query1.setParameter("name", "%" + name + "%");
//            productList = query1.getResultList();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return productList;
    }
}
