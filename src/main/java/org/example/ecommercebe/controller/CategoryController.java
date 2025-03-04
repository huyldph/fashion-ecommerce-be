package org.example.ecommercebe.controller;

import lombok.RequiredArgsConstructor;
import org.example.ecommercebe.dto.category.CategoryResponse;
import org.example.ecommercebe.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/public/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    private ResponseEntity<List<CategoryResponse>> getAllCategories() {
        return ResponseEntity.ok(categoryRepository.findAllCategories());
    }
}
