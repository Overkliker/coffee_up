package com.example.buhg_rest.controller;
import com.example.buhg_rest.model.Inventory;
import com.example.buhg_rest.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    @Autowired
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }


    @GetMapping
    public List<Inventory> getAll() {
        return inventoryService.getAll();
    }

    @GetMapping("/{id}")
    public Inventory getById(@PathVariable Long id) {
        return inventoryService.getById(id);
    }

    @PostMapping
    public Inventory create(@RequestBody Inventory shop) {
        return inventoryService.save(shop);
    }

    @PostMapping("/{id}")
    public Inventory update(@PathVariable Long id, @RequestBody Inventory details) {
        Inventory employee = inventoryService.getById(id);
        employee.setProduct(details.getProduct());
        employee.setReorderLevel(details.getReorderLevel());
        employee.setQuantityInStock(details.getQuantityInStock());
        return inventoryService.save(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteShop(@PathVariable Long id) {
        inventoryService.delete(id);
    }
}
