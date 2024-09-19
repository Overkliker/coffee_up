package com.example.buhg_rest.service;

import com.example.buhg_rest.model.CoffeeShop;
import com.example.buhg_rest.repository.CoffeeShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeShopService {
    private final CoffeeShopRepository coffeeShopRepository;

    @Autowired
    public CoffeeShopService(CoffeeShopRepository coffeeShopRepository) {
        this.coffeeShopRepository = coffeeShopRepository;
    }

    public List<CoffeeShop> getAll() {
        return coffeeShopRepository.findAll();
    }

    public CoffeeShop getById(Long id) {
        return coffeeShopRepository.findById(id).orElseThrow(() -> new RuntimeException("Shop not found"));
    }

    public CoffeeShop save(CoffeeShop shop) {
        return coffeeShopRepository.save(shop);
    }

    public void delete(Long id) {
        coffeeShopRepository.deleteById(id);
    }
}