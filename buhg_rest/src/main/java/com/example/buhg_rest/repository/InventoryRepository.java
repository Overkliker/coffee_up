package com.example.buhg_rest.repository;

import com.example.buhg_rest.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}