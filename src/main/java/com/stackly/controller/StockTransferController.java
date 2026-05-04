package com.stackly.controller;

import com.stackly.DTO.TransferRequest;
import com.stackly.service.StockTransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transfer")
@RequiredArgsConstructor
public class StockTransferController {

    private final StockTransferService service;

    @PostMapping
    public String transfer(@RequestBody TransferRequest req) {
        service.transfer(req);
        return "Stock transferred successfully";
    }
}