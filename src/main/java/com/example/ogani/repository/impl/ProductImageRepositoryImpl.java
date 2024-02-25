package com.example.ogani.repository.impl;

import com.example.ogani.repository.ProductImageRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class ProductImageRepositoryImpl implements ProductImageRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void deleteByImageId(Long id) {
        Query query = entityManager.createNativeQuery("DELETE FROM product_image WHERE image_id = " + id);
        query.executeUpdate();
    }
}
