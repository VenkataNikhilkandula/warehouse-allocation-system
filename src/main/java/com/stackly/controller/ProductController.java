package com.stackly.controller;
import com.stackly.DTO.ProductRequest;
import com.stackly.entity.Product;
import com.stackly.service.ProductService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping
    public Product create(@RequestBody ProductRequest req) {
        return service.create(req);
    }

    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }
}
