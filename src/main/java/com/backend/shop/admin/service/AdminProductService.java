package com.backend.shop.admin.service;

import com.backend.shop.admin.dto.request.AdminProductRequest;
import com.backend.shop.admin.dto.response.AdminProductResponse;
import com.backend.shop.admin.model.AdminProduct;
import com.backend.shop.admin.repository.AdminProductRepository;
import com.backend.shop.admin.service.converter.AdminProductConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminProductService {

    private final AdminProductRepository adminProductRepository;
    private final AdminProductConverter adminProductConverter;

    public Page<AdminProductResponse> getProducts(Pageable pageable) {
        return adminProductRepository.findAll(pageable)
                .map(adminProductConverter::toDto);
    }

    public AdminProductResponse getProduct(Long id) {
        return adminProductConverter.toDto(adminProductRepository.findById(id).orElseThrow());
    }

    public AdminProductResponse createProduct(AdminProductRequest request) {
        AdminProduct adminProductToAdd = adminProductConverter.fromDto(request);
        AdminProduct savedAdminProduct = adminProductRepository.save(adminProductToAdd);
        return adminProductConverter.toDto(savedAdminProduct);
    }

    public AdminProductResponse updateProduct(AdminProductRequest request, Long id) {
        AdminProduct productToModify = adminProductRepository.findById(id).orElseThrow();
        productToModify.setName(request.getName());
        productToModify.setDescription(request.getDescription());
        productToModify.setCurrency(request.getCurrency());
        productToModify.setPrice(request.getPrice());
        productToModify.setCategory(request.getCategory());
        return adminProductConverter.toDto(productToModify);
    }
}
