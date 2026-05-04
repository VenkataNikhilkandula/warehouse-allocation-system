package com.stackly.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductRequest {

    @NotNull
    private String name;

    @NotNull
    private String sku;

    @NotNull
    private Integer totalStock;
}