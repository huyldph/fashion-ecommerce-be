package com.example.service.impl;

import com.example.dto.response.ProductsResponse;
import com.example.entity.Product;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductsResponse> findAllProductsAndVariants() {
        return productRepository.findAllProductsAndVariants();
    }
}
