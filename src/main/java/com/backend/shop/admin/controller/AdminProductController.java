package com.backend.shop.admin.controller;

import com.backend.shop.admin.dto.request.AdminProductRequest;
import com.backend.shop.admin.dto.response.AdminProductResponse;
import com.backend.shop.admin.service.AdminProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AdminProductController {

    private final AdminProductService adminProductService;

    @GetMapping("/admin/products")
    public Page<AdminProductResponse> getProducts(Pageable pageable){
        return adminProductService.getProducts(pageable);
    }
    @GetMapping("/admin/products/{id}")
    public AdminProductResponse getProduct(@PathVariable Long id){
        return adminProductService.getProduct(id);
    }
    @PostMapping("/admin/products")
    public AdminProductResponse addProduct(@RequestBody AdminProductRequest request){
        return adminProductService.createProduct(request);
    }
    @PutMapping("/admin/products/{id}")
    public AdminProductResponse updateProduct(@RequestBody AdminProductRequest request, @PathVariable Long id){
        return adminProductService.updateProduct(request, id);
    }

}

