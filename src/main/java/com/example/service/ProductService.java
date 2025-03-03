package com.example.service;

import com.example.dto.response.ProductsResponse;
import com.example.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductsResponse> findAllProductsAndVariants();
}
