package com.dharbor.sales.services;

import com.dharbor.sales.clients.StockFeignClient;
import com.dharbor.sales.model.rest.ProductReservationRequest;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Josue Veliz
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class StockService {

    private final StockFeignClient stockFeignClient;

    @CircuitBreaker(name = "stockService", fallbackMethod = "fallbackReserve")
    public String reserve(String productId, int quantity) {
        ProductReservationRequest request = new ProductReservationRequest();
        request.setProductId(productId);
        request.setQuantity(quantity);
        return stockFeignClient.reserve(request);
    }

    public String fallbackReserve(String productId, int quantity, Throwable t) {
        log.error("Stock service unavailable: {}", t.getMessage());
        return "reservation-failed";
    }
}
