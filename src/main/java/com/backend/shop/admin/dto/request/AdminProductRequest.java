package com.backend.shop.admin.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AdminProductRequest {
    private String name;
    private String category;
    private String description;
    private BigDecimal price;
    private String currency;
}
