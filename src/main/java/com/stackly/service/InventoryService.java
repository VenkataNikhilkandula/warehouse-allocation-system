package com.stackly.service;

import com.stackly.entity.Inventory;
import java.util.List;

public interface InventoryService {

    Inventory create(Inventory inventory);

    List<Inventory> getByProduct(Long productId);
}