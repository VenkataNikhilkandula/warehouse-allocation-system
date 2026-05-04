package com.stackly.DTO;

import com.stackly.entity.Product;
import java.util.List;

public interface ProductService {
    Product create(ProductRequest request);
    List<Product> getAll();
}