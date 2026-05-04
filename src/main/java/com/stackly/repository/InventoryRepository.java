//package com.stackly.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.stackly.entity.WarehouseInventory;
//
//public interface InventoryRepository extends JpaRepository<WarehouseInventory, Long> {
//    List<WarehouseInventory> findByProductId(Long productId);
//}

package com.stackly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stackly.entity.Inventory;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    List<Inventory> findByProductId(Long productId);

    Optional<Inventory> findByProductIdAndWarehouseId(Long productId, Long warehouseId);
}