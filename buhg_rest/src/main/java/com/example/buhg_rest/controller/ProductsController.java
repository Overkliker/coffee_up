package com.example.buhg_rest.controller;

import com.example.buhg_rest.model.Product;
import com.example.buhg_rest.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {

    @Autowired
    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }


    @GetMapping
    public List<Product> getAll() {
        return productsService.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productsService.getById(id);
    }

    @PostMapping
    public Product create(@RequestBody Product shop) {
        return productsService.save(shop);
    }

    @PostMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product details) {
        Product employee = productsService.getById(id);
        employee.setName(details.getName());
        employee.setCategory(details.getCategory());
        employee.setPrice(details.getPrice());
        return productsService.save(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteShop(@PathVariable Long id) {
        productsService.delete(id);
    }
}

