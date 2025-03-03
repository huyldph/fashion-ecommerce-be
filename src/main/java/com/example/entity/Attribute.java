package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Attributes")
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attributeId;

    @Column(nullable = false)
    private String attributeName;

    @Column(nullable = false)
    private String dataType;

    @OneToMany(mappedBy = "attribute")
    private List<AttributeValue> attributeValues;
}