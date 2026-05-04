package com.stackly.service;

import com.stackly.DTO.AllocationRequest;
import com.stackly.entity.Allocation;

public interface AllocationService {
    Allocation allocate(AllocationRequest request);
}