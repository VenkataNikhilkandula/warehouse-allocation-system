package com.stackly.serviceimplementation;

import com.stackly.entity.Inventory;
import com.stackly.repository.InventoryRepository;
import com.stackly.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository repo;

    @Override
    public Inventory create(Inventory inventory) {
        return repo.save(inventory);
    }

    @Override
    public List<Inventory> getByProduct(Long productId) {
        return repo.findByProductId(productId);
    }
}