package com.backend.shop.product.service.converter;

import com.backend.shop.admin.service.converter.Convertable;
import com.backend.shop.product.dto.ProductRequest;
import com.backend.shop.product.dto.ProductResponse;
import com.backend.shop.product.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductConverter implements Convertable<ProductRequest, Product, ProductResponse> {

    @Override
    public Product fromDto(ProductRequest productRequest) {
        Product product = new Product();
        product.setPrice(productRequest.getPrice());
        product.setName(productRequest.getName());
        product.setCategory(productRequest.getCategory());
        product.setCurrency(productRequest.getCurrency());
        product.setDescription(productRequest.getDescription());
        return product;
    }

    @Override
    public ProductResponse toDto(Product product) {
        return ProductResponse.builder()
                .name(product.getName())
                .id(product.getId())
                .category(product.getCategory())
                .currency(product.getCurrency())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
