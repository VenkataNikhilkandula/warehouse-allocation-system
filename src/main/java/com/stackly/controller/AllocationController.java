package com.stackly.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackly.DTO.AllocationRequest;
import com.stackly.entity.Allocation;
import com.stackly.service.AllocationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/allocations")
@RequiredArgsConstructor
public class AllocationController {

    private final AllocationService service;

    @PostMapping
    public Allocation allocate(@RequestBody AllocationRequest req) {
        return service.allocate(req);
    }
    
}
