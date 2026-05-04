package com.stackly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackly.entity.Product;

public interface Productrepository extends JpaRepository<Product, Long> {}
