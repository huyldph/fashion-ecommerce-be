package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "Product_Variants")
public class ProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer variantId;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer stockLevel;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(mappedBy = "variant")
    private List<VariantAttribute> variantAttributes;

    @OneToMany(mappedBy = "variant")
    private List<OrderItem> orderItems;
} 