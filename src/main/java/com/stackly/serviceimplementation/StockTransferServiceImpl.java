//package com.stackly.serviceimplementation;
//
//import com.stackly.DTO.TransferRequest;
//import com.stackly.entity.Inventory;
//import com.stackly.entity.StockTransfer;
//import com.stackly.entity.WarehouseInventory;
//import com.stackly.repository.InventoryRepository;
//import com.stackly.repository.StockTransferrepository;
//import com.stackly.service.StockTransferService;
//import lombok.RequiredArgsConstructor;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//
//@Service
//@RequiredArgsConstructor
//public class StockTransferServiceImpl implements StockTransferService {
//    @Autowired
//    private InventoryRepository inventoryRepo;
//    private  StockTransferrepository transferRepo;
//
//    public void transfer(TransferRequest req) {
//
//        Inventory source = inventoryRepo.findByProductId(req.getProductId())
//                .stream()
//                .filter(i -> i.getWarehouseId().equals(req.getSourceWarehouseId()))
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("Source not found"));
//
//        Inventory target = inventoryRepo.findByProductId(req.getProductId())
//                .stream()
//                .filter(i -> i.getWarehouseId().equals(req.getTargetWarehouseId()))
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("Target not found"));
//
//        if (source.getAvailableStock() < req.getQuantity()) {
//            throw new RuntimeException("Insufficient stock");
//        }
//
//        source.setAvailableStock(source.getAvailableStock() - req.getQuantity());
//        target.setAvailableStock(target.getAvailableStock() + req.getQuantity());
//
//        inventoryRepo.save(source);
//        inventoryRepo.save(target);
//
//        StockTransfer transfer = new StockTransfer();
//        transfer.setProductId(req.getProductId());
//        transfer.setSourceWarehouseId(req.getSourceWarehouseId());
//        transfer.setTargetWarehouseId(req.getTargetWarehouseId());
//        transfer.setQuantity(req.getQuantity());
//        transfer.setTransferDate(LocalDateTime.now());
//
//        transferRepo.save(transfer);
//    }
//}




package com.stackly.serviceimplementation;

import com.stackly.DTO.TransferRequest;
import com.stackly.entity.Inventory;
import com.stackly.entity.StockTransfer;
import com.stackly.repository.InventoryRepository;
import com.stackly.repository.StockTransferrepository;
import com.stackly.service.StockTransferService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class StockTransferServiceImpl implements StockTransferService {

    private final InventoryRepository inventoryRepo;
    private final StockTransferrepository transferRepo;

    @Override
    @Transactional
    public void transfer(TransferRequest req) {

        // ✅ Fetch source inventory
        Inventory source = inventoryRepo
                .findByProductIdAndWarehouseId(
                        req.getProductId(),
                        req.getSourceWarehouseId()
                )
                .orElseThrow(() -> new RuntimeException("Source warehouse inventory not found"));

        // ✅ Fetch target inventory
        Inventory target = inventoryRepo
                .findByProductIdAndWarehouseId(
                        req.getProductId(),
                        req.getTargetWarehouseId()
                )
                .orElseThrow(() -> new RuntimeException("Target warehouse inventory not found"));

        // ✅ Stock validation
        if (source.getAvailableStock() < req.getQuantity()) {
            throw new RuntimeException("Insufficient stock in source warehouse");
        }

        // ✅ Update stock
        source.setAvailableStock(
                source.getAvailableStock() - req.getQuantity()
        );

        target.setAvailableStock(
                target.getAvailableStock() + req.getQuantity()
        );

        inventoryRepo.save(source);
        inventoryRepo.save(target);

        // ✅ Save transfer history
        StockTransfer transfer = new StockTransfer();
        transfer.setProductId(req.getProductId());
        transfer.setSourceWarehouseId(req.getSourceWarehouseId());
        transfer.setTargetWarehouseId(req.getTargetWarehouseId());
        transfer.setQuantity(req.getQuantity());
        transfer.setTransferDate(LocalDateTime.now());

        transferRepo.save(transfer);
    }
}