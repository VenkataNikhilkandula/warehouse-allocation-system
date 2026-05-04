package com.stackly.DTO;

import lombok.Data;

@Data
public class TransferRequest {
    private Long productId;
    private Long sourceWarehouseId;
    private Long targetWarehouseId;
    private Integer quantity;
}