package org.example.ecommercebe.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    @Column(name = "product_name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    private Integer purchases = 0;

    @OneToMany(mappedBy = "product")
    private List<ProductVariant> variants;

    @OneToMany(mappedBy = "product")
    private List<ProductAttribute> productAttributes;
}