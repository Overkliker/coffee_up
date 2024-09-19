package com.example.buhg_rest.service;

import com.example.buhg_rest.model.Product;
import com.example.buhg_rest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Shop not found"));
    }

    public Product save(Product shop) {
        return productRepository.save(shop);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}