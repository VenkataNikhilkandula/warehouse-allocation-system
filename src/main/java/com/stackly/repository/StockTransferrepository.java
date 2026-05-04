package com.stackly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackly.entity.StockTransfer;

public interface StockTransferrepository extends JpaRepository<StockTransfer, Long> {}