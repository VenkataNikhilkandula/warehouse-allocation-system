package com.stackly.serviceimplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stackly.DTO.WarehouseRequest;
import com.stackly.entity.Warehouse;
import com.stackly.enums.WarehouseStatus;
import com.stackly.repository.WarehouseRepository;
import com.stackly.service.WarehouseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository repo;

    public Warehouse create(WarehouseRequest req) {
        Warehouse w = new Warehouse();
        w.setName(req.getName());
        w.setLocation(req.getLocation());
        w.setCapacity(req.getCapacity());
        w.setStatus(WarehouseStatus.ACTIVE);
        return repo.save(w);
    }

    public List<Warehouse> getAll() {
        return repo.findAll().stream()
                .filter(w -> !w.isDeleted())
                .toList();
    }

    public void softDelete(Long id) {
        Warehouse w = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        w.setDeleted(true);
        repo.save(w);
    }
}