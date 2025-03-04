package org.example.ecommercebe.model;

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
    @Column(name = "variant_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "stock_level", nullable = false)
    private Integer stockLevel;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "variant")
    private List<VariantAttribute> variantAttributes;

    @OneToMany(mappedBy = "variant")
    private List<OrderItem> orderItems;
} 