package com.dharbor.stock.service;

import com.dharbor.stock.api.request.ProductReservationRequest;
import com.dharbor.stock.api.response.ProductReservationResponse;
import com.dharbor.stock.model.domain.ProductReservation;
import com.dharbor.stock.model.repository.ProductReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Josue Veliz
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductReservationRepository repository;

    public ProductReservationResponse reserveProduct(ProductReservationRequest request) {
        ProductReservation reservation = new ProductReservation();
        reservation.setId(UUID.randomUUID().toString());
        reservation.setProductId(request.getProductId());
        reservation.setQuantity(request.getQuantity());
        reservation.setCreatedAt(System.currentTimeMillis());

        repository.save(reservation);

        return new ProductReservationResponse(reservation.getId());
    }
}
