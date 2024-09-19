package com.example.buhg_rest.controller;

import com.example.buhg_rest.model.SaleItem;
import com.example.buhg_rest.service.SaleItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/saleItem")
public class SaleItemController {
    private final SaleItemService saleItemService;

    @Autowired
    public SaleItemController(SaleItemService saleItemService) {
        this.saleItemService = saleItemService;
    }

    @GetMapping
    public List<SaleItem> getAllShops() {
        return saleItemService.getAll();
    }

    @GetMapping("/{id}")
    public SaleItem getShopById(@PathVariable Long id) {
        return saleItemService.getById(id);
    }

    @PostMapping
    public SaleItem createShop(@RequestBody SaleItem shop) {
        return saleItemService.save(shop);
    }

    @PostMapping("/{id}")
    public SaleItem updateShop(@PathVariable Long id, @RequestBody SaleItem details) {
        SaleItem shop = saleItemService.getById(id);
        shop.setSale(details.getSale());
        shop.setProduct(details.getProduct());
        shop.setQuantity(details.getQuantity());
        shop.setSubtotal(details.getSubtotal());
        return saleItemService.save(shop);
    }

    @DeleteMapping("/{id}")
    public void deleteShop(@PathVariable Long id) {
        saleItemService.delete(id);
    }
}