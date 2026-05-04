package com.stackly.service;

import com.stackly.DTO.ProductRequest;
import com.stackly.DTO.ProductResponse;
import com.stackly.entity.Product;

import java.util.List;

//public interface ProductService {

//    ProductResponse create(ProductRequest request);
//
//    List<Product> getAll();
//
//    ProductResponse getById(Long id);
//
//    ProductResponse update(Long id, ProductRequest request);
//
//    void delete(Long id);
//}



public interface ProductService {

    Product create(ProductRequest request);   // ✅ MUST MATCH

    List<Product> getAll();

	ProductResponse getById(Long id);

	ProductResponse update(Long id, ProductRequest request);

	void delete(Long id);
}