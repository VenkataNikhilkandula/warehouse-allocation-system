package com.stackly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackly.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {}


