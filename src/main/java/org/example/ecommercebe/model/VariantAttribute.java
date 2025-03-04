package org.example.ecommercebe.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Variant_Attributes")
public class VariantAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "variant_attribute_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "variant_id")
    private ProductVariant variant;

    @ManyToOne
    @JoinColumn(name = "attribute_value_id")
    private AttributeValue attributeValue;
} 