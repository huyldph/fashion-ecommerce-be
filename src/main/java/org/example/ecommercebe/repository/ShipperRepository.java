package org.example.ecommercebe.repository;

import org.example.ecommercebe.model.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper, Integer> {
} 