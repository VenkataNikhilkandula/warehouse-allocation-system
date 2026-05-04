package com.stackly.DTO;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AllocationResponse {
    private Long id;
    private Long productId;
    private Long warehouseId;
    private Integer quantity;
    private LocalDateTime allocatedAt;
}