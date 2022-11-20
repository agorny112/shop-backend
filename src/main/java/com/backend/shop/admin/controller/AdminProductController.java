package com.backend.shop.admin.controller;

import com.backend.shop.admin.model.AdminProduct;
import com.backend.shop.admin.service.AdminProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminProductController {

    private final AdminProductService adminProductService;

    @GetMapping("/admin/products")
    public Page<AdminProduct> getProducts(Pageable pageable){
        return adminProductService.getProducts(pageable);
    }
}