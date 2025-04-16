package com.dharbor.stock.controller;

import com.dharbor.stock.api.request.ProductReservationRequest;
import com.dharbor.stock.api.response.ProductReservationResponse;
import com.dharbor.stock.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Josue Veliz
 */
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductService productService;

    @PostMapping("/reserve")
    public ResponseEntity<ProductReservationResponse> reserve(
            @Valid @RequestBody ProductReservationRequest request
    ) {
        ProductReservationResponse response = productService.reserveProduct(request);
        return ResponseEntity.ok(response);
    }
}
