package org.example.ecommercebe.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Attributes")
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attribute_id")
    private Integer id;

    @Column(name = "attribute_name", nullable = false)
    private String name;

    @Column(name = "data_type", nullable = false)
    private String dataType;

    @OneToMany(mappedBy = "attribute")
    private List<AttributeValue> attributeValues;
}