package com.stackly.DTO;

import lombok.Data;

@Data
public class WarehouseResponse {
    private Long id;
    private String name;
    private String location;
    private Integer capacity;
}