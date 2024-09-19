package com.example.buhg_rest.controller;

import com.example.buhg_rest.model.CoffeeShop;
import com.example.buhg_rest.service.CoffeeShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coffeeShops")
public class CoffeeShopController {
    private final CoffeeShopService coffeeShopService;

    @Autowired
    public CoffeeShopController(CoffeeShopService coffeeShopService) {
        this.coffeeShopService = coffeeShopService;
    }

    @GetMapping
    public List<CoffeeShop> getAllShops() {
        return coffeeShopService.getAll();
    }

    @GetMapping("/{id}")
    public CoffeeShop getShopById(@PathVariable Long id) {
        return coffeeShopService.getById(id);
    }

    @PostMapping
    public CoffeeShop createShop(@RequestBody CoffeeShop shop) {
        return coffeeShopService.save(shop);
    }

    @PostMapping("/update/{id}")
    public CoffeeShop updateShop(@PathVariable Long id, @RequestBody CoffeeShop details) {
        CoffeeShop shop = coffeeShopService.getById(id);
        shop.setName(details.getName());
        shop.setLocation(details.getLocation());
        shop.setPhone(details.getPhone());
        shop.setEmail(details.getEmail());
        return coffeeShopService.save(shop);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteShop(@PathVariable Long id) {
        coffeeShopService.delete(id);
    }
}