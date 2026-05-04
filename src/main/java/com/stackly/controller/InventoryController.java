package com.stackly.controller;

import com.stackly.entity.Inventory;
import com.stackly.service.InventoryService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    @Autowired
    private InventoryService service;

    @PostMapping
    public Inventory create(@RequestBody Inventory inventory) {
        return service.create(inventory);
    }

    @GetMapping("/product/{productId}")
    public List<Inventory> getByProduct(@PathVariable Long productId) {
        return service.getByProduct(productId);
    }
}