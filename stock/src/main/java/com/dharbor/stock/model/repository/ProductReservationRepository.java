package com.dharbor.stock.model.repository;

import com.dharbor.stock.model.domain.ProductReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReservationRepository extends JpaRepository<ProductReservation, Long> {
}
