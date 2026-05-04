package com.stackly.service;

import java.util.List;

import com.stackly.DTO.WarehouseRequest;
import com.stackly.entity.Warehouse;

public interface WarehouseService {
    Warehouse create(WarehouseRequest request);
    List<Warehouse> getAll();
    void softDelete(Long id);
}