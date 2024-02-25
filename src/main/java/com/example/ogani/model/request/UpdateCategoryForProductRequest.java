package com.example.ogani.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryForProductRequest {
    private List<Long> productIds;
    private Long categoryId;
}
