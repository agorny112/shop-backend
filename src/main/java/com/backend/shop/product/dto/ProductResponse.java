package com.backend.shop.product.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class ProductResponse {

    private Long id;
    private String name;
    private String category;
    private String description;
    private BigDecimal price;
    private String currency;
}
