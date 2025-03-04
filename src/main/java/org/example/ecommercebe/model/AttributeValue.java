package org.example.ecommercebe.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Attribute_Values")
public class AttributeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attribute_value_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "attribute_id")
    private Attribute attribute;

    @Column(nullable = false)
    private String value;

    @OneToMany(mappedBy = "attributeValue")
    private List<ProductAttribute> productAttributes;

    @OneToMany(mappedBy = "attributeValue")
    private List<VariantAttribute> variantAttributes;
} 