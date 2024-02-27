package com.example.ogani.repository.impl;

import com.example.ogani.repository.ProductImageRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductImageRepositoryImpl implements ProductImageRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void deleteByImageId(Long id) {
        Query query = entityManager.createNativeQuery("DELETE FROM product_image WHERE image_id = " + id);
        query.executeUpdate();
    }

    @Override
    public void deleteByProductId(Long id) {
        Query query = entityManager.createNativeQuery("DELETE FROM product_image WHERE product_id = " + id);
        query.executeUpdate();
    }

    @Override
    public void deleteByListProductId(List<Long> ids) {
        StringBuilder sql = new StringBuilder("DELETE FROM product_image WHERE image_id IN (");
        String idsStr = ids.stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));
        sql.append(idsStr);
        sql.append(")");
        Query query = entityManager.createNativeQuery(sql.toString());
        query.executeUpdate();
    }


}
