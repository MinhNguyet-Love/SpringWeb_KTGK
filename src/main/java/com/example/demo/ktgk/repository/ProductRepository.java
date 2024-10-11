package com.example.demo.ktgk.repository;

import com.example.demo.ktgk.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// Rename to ProductRepository
public interface ProductRepository extends JpaRepository<Product, Long> {
}