package com.example.buhg_rest.repository;

import com.example.buhg_rest.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}