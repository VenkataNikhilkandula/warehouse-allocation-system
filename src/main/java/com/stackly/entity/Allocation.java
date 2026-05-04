package com.stackly.entity;

import java.time.LocalDateTime;

import com.stackly.enums.AllocationStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Allocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;
    private Long warehouseId;

    private Integer quantity;

    private LocalDateTime allocatedAt;

    @Enumerated(EnumType.STRING)
    private AllocationStatus status;
}