package com.dharbor.sales.rest;

import com.dharbor.sales.model.dto.NewSaleDto;
import com.dharbor.sales.model.rest.NewSaleRequest;
import com.dharbor.sales.services.NewSalesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SalesController {

    private final NewSalesService newSalesService;

    @PostMapping
    public ResponseEntity<String> createNewSale(@RequestBody NewSaleRequest newSaleRequest) {
        NewSaleDto dto = NewSaleDto.builder()
                .userId(newSaleRequest.getUserId())
                .productId(newSaleRequest.getProductId())
                .quantity(newSaleRequest.getQuantity())
                .build();

        String result = newSalesService.newSale(dto);
        return ResponseEntity.ok(result);
    }
}

