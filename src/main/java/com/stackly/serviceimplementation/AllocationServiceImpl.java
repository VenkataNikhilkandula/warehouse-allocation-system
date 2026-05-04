package com.stackly.serviceimplementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.stackly.DTO.AllocationRequest;
import com.stackly.entity.Allocation;
import com.stackly.entity.Inventory;
import com.stackly.entity.Product;
import com.stackly.enums.AllocationStatus;
import com.stackly.repository.Allocationrepository;
import com.stackly.repository.InventoryRepository;
import com.stackly.repository.Productrepository;
import com.stackly.service.AllocationService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AllocationServiceImpl implements AllocationService {

    private final Productrepository productRepo;
    private final InventoryRepository inventoryRepo;
    private final Allocationrepository allocationRepo;

    @Override
    @Transactional
    public Allocation allocate(AllocationRequest req) {

        // 1. Validate product
        Product product = productRepo.findById(req.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // 2. Fetch inventory for product
        List<Inventory> inventories =
                inventoryRepo.findByProductId(req.getProductId());

        if (inventories.isEmpty()) {
            throw new RuntimeException("No inventory found for this product");
        }

        // 3. Find warehouse with sufficient stock
        Inventory selected = inventories.stream()
                .filter(i -> i.getAvailableStock() >= req.getQuantity())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Insufficient stock"));

        // 4. Deduct stock
        selected.setAvailableStock(
                selected.getAvailableStock() - req.getQuantity()
        );
        inventoryRepo.save(selected);

        // 5. Create allocation record
        Allocation allocation = new Allocation();
        allocation.setProductId(req.getProductId());
        allocation.setWarehouseId(selected.getWarehouseId());
        allocation.setQuantity(req.getQuantity());
        allocation.setAllocatedAt(LocalDateTime.now());
        allocation.setStatus(AllocationStatus.SUCCESS);

        return allocationRepo.save(allocation);
    }
}