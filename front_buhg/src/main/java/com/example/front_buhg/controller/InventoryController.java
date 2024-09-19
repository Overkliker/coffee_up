package com.example.front_buhg.controller;

import com.example.front_buhg.model.Inventory;
import com.example.front_buhg.model.Product;
import com.example.front_buhg.service.InventoryApi;
import com.example.front_buhg.service.ProductApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/inventories")
public class InventoryController {
    @Autowired
    private InventoryApi inventoryApi;

    @Autowired
    private ProductApi productApi;


    @GetMapping
    public String getAllInventories(Model model) {
        Inventory[] inventories = inventoryApi.getAll();
        model.addAttribute("inventories", inventories);
        return "inventory/inventories";
    }

    @GetMapping("/{id}")
    public String getInventoryById(@PathVariable Long id, Model model) {
        Inventory inventory = inventoryApi.getById(id);
        Product[] products = productApi.getAll();
        model.addAttribute("inventory", inventory);
        model.addAttribute("products", products);
        return "inventory/inventory";
    }

    @GetMapping("/create")
    public String createInventory(Model model) {
        Product[] products = productApi.getAll();
        model.addAttribute("inventory", new Inventory());
        model.addAttribute("products", products);
        return "inventory/createInventory";
    }

    @PostMapping("/create")
    public String saveInventory(@RequestParam Long prodId, Inventory inventory) {
        inventory.setProduct(productApi.getById(prodId));
        inventoryApi.save(inventory);
        return "redirect:/inventories";
    }

    @PostMapping("/update/{id}")
    public String updateInventory(
            @PathVariable Long id,
            @RequestParam Long prodId,
            @RequestParam Integer quantityInStock,
            @RequestParam Integer reorderLevel
                                  ) {
        Inventory updated = inventoryApi.getById(id);
        updated.setProduct(productApi.getById(prodId));
        updated.setQuantityInStock(quantityInStock);
        updated.setReorderLevel(reorderLevel);

        inventoryApi.update(updated, id);
        return "redirect:/inventories";

    }

    @GetMapping("/delete/{id}")
    public String deleteInventory(@PathVariable Long id) {
        inventoryApi.delete(id);
        return "redirect:/inventories";
    }
}
