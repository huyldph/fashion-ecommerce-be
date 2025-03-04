package org.example.ecommercebe.repository;

import org.example.ecommercebe.dto.category.CategoryResponse;
import org.example.ecommercebe.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query(
            """
                    SELECT new org.example.ecommercebe.dto.category.CategoryResponse(
                    c.id,
                    c.name
                    ) FROM Category c
                    """
    )
    List<CategoryResponse> findAllCategories();
}