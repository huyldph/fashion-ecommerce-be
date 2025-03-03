package com.example.repository;

import com.example.dto.response.ProductsResponse;
import com.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(
            """
                    select new com.example.dto.response.ProductsResponse(
                        p.productId,
                        p.productName,
                        pv.price,
                        pv.imageUrl,
                        c.categoryName,
                        p.purchases
                    ) from Product p join p.category c
                        join p.productVariants pv
                    """
    )
    List<ProductsResponse> findAllProductsAndVariants();
}
