package com.example.buhg_rest.repository;

import com.example.buhg_rest.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}