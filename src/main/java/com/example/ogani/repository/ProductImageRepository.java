package com.example.ogani.repository;

import java.util.List;

public interface ProductImageRepository {
    void deleteByImageId(Long id);

    void deleteByProductId(Long id);

    void deleteByListProductId(List<Long> ids);
}
