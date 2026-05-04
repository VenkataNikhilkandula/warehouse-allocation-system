package com.stackly.service;


import com.stackly.DTO.TransferRequest;

public interface StockTransferService {
    void transfer(TransferRequest request);
}