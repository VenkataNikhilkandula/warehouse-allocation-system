package com.stackly.DTO;

import lombok.Data;

@Data
public class WarehouseRequest {
    private String name;
    private String location;
    private Integer capacity;
}