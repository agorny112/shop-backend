package com.backend.shop.product.service;

import com.backend.shop.product.dto.ProductResponse;
import com.backend.shop.product.repository.ProductRepository;
import com.backend.shop.product.service.converter.ProductConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;


    public Page<ProductResponse> getProducts(Pageable pageable) {
        return productRepository.findAll(pageable).map(productConverter::toDto);

    }
}
