package com.example.cardinalities.domain.orderingposition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderingPositionRepository extends JpaRepository<OrderingPosition, UUID> {
}
