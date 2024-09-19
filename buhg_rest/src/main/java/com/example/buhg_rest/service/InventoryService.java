package com.example.buhg_rest.service;

import com.example.buhg_rest.model.Inventory;
import com.example.buhg_rest.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<Inventory> getAll() {
        return inventoryRepository.findAll();
    }

    public Inventory getById(Long id) {
        return inventoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Shop not found"));
    }

    public Inventory save(Inventory shop) {
        return inventoryRepository.save(shop);
    }

    public void delete(Long id) {
        inventoryRepository.deleteById(id);
    }
}