package com.dharbor.sales.model.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class NewSaleDto {

    private UUID userId;
    private String productId;
    private Integer quantity;

}
