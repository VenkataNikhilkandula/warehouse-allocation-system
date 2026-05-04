package com.stackly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackly.entity.Allocation;

public interface Allocationrepository extends JpaRepository<Allocation, Long> {}