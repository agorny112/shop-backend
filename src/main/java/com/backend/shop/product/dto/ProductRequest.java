package com.backend.shop.product.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {

    private String name;
    private String category;
    private String description;
    private BigDecimal price;
    private String currency;
}
