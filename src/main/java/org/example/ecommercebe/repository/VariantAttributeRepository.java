package org.example.ecommercebe.repository;

import org.example.ecommercebe.model.VariantAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantAttributeRepository extends JpaRepository<VariantAttribute, Integer> {
} 