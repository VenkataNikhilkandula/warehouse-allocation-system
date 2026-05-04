package com.stackly.entity;
import com.stackly.enums.WarehouseStatus;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private Integer capacity;

    @Enumerated(EnumType.STRING)
    private WarehouseStatus status;

    private boolean deleted = false;

    private LocalDateTime createdAt = LocalDateTime.now();
}