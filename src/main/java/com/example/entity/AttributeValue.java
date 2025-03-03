package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Attribute_Values")
public class AttributeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attributeValueId;

    @Column(nullable = false)
    private String value;

    @ManyToOne
    @JoinColumn(name = "attribute_id")
    private Attribute attribute;

    @OneToMany(mappedBy = "attributeValue")
    private List<ProductAttribute> productAttributes;

    @OneToMany(mappedBy = "attributeValue")
    private List<VariantAttribute> variantAttributes;
} 