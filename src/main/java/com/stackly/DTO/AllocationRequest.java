package com.stackly.DTO;

import lombok.Data;

@Data
public class AllocationRequest {
    private Long productId;
    private Integer quantity;
}