package org.example.ecommercebe.repository;

import org.example.ecommercebe.dto.product.ProductResponse;
import org.example.ecommercebe.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("""
            SELECT new org.example.ecommercebe.dto.product.ProductResponse(
                p.id,
                p.name,
                pv.price,
                pv.imageUrl,
                c.name,
                p.purchases
            ) FROM Product p 
            JOIN p.category c 
            JOIN p.variants pv
            """)
    List<ProductResponse> findAllProductAndVariants();
    
    @Query("""
            SELECT new org.example.ecommercebe.dto.product.ProductResponse(
                p.id,
                p.name,
                pv.price,
                pv.imageUrl,
                c.name,
                p.purchases
            ) FROM Product p 
            JOIN p.category c 
            JOIN p.variants pv
            WHERE c.id = :categoryId
            """)
    List<ProductResponse> findByCategoryId(Long categoryId);
    
    @Query("""
            SELECT p FROM Product p
            JOIN FETCH p.variants
            JOIN FETCH p.category
            WHERE p.id = :productId
            """)
    Optional<Product> findByIdWithDetails(Long productId);
} 