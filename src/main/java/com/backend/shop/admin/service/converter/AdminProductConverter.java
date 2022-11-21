package com.backend.shop.admin.service.converter;

import com.backend.shop.admin.dto.request.AdminProductRequest;
import com.backend.shop.admin.dto.response.AdminProductResponse;
import com.backend.shop.admin.model.AdminProduct;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class AdminProductConverter implements Convertable<AdminProductRequest, AdminProduct, AdminProductResponse>{

    @Override
    public AdminProduct fromDto(AdminProductRequest adminProductRequest) {
        AdminProduct adminProduct = new AdminProduct();
        adminProduct.setPrice(adminProductRequest.getPrice());
        adminProduct.setName(adminProductRequest.getName());
        adminProduct.setCategory(adminProductRequest.getCategory());
        adminProduct.setCurrency(adminProductRequest.getCurrency().toUpperCase(Locale.ROOT));
        adminProduct.setDescription(adminProductRequest.getDescription());
        return adminProduct;
    }

    @Override
    public AdminProductResponse toDto(AdminProduct adminProduct) {
        return AdminProductResponse.builder()
                .name(adminProduct.getName())
                .id(adminProduct.getId())
                .category(adminProduct.getCategory())
                .currency(adminProduct.getCurrency())
                .description(adminProduct.getDescription())
                .price(adminProduct.getPrice())
                .build();
    }
}
