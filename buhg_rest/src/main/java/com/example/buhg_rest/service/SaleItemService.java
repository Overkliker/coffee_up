package com.example.buhg_rest.service;

import com.example.buhg_rest.model.SaleItem;
import com.example.buhg_rest.repository.SaleItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleItemService {
    private final SaleItemRepository saleItemRepository;

    @Autowired
    public SaleItemService(SaleItemRepository saleRepository) {
        this.saleItemRepository = saleRepository;
    }

    public List<SaleItem> getAll() {
        return saleItemRepository.findAll();
    }

    public SaleItem getById(Long id) {
        return saleItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Shop not found"));
    }

    public SaleItem save(SaleItem shop) {
        return saleItemRepository.save(shop);
    }

    public void delete(Long id) {
        saleItemRepository.deleteById(id);
    }
}
