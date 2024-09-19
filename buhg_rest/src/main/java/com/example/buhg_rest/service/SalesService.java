package com.example.buhg_rest.service;

import com.example.buhg_rest.model.Sale;
import com.example.buhg_rest.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {
    private final SaleRepository saleRepository;

    @Autowired
    public SalesService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<Sale> getAll() {
        return saleRepository.findAll();
    }

    public Sale getById(Long id) {
        return saleRepository.findById(id).orElseThrow(() -> new RuntimeException("Shop not found"));
    }

    public Sale save(Sale shop) {
        return saleRepository.save(shop);
    }

    public void delete(Long id) {
        saleRepository.deleteById(id);
    }
}