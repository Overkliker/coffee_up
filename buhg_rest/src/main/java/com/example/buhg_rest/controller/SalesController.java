package com.example.buhg_rest.controller;

import com.example.buhg_rest.model.Sale;
import com.example.buhg_rest.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sales")
public class SalesController {

    @Autowired
    private final SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }


    @GetMapping
    public List<Sale> getAll() {
        return salesService.getAll();
    }

    @GetMapping("/{id}")
    public Sale getById(@PathVariable Long id) {
        return salesService.getById(id);
    }

    @PostMapping
    public Sale create(@RequestBody Sale shop) {
        return salesService.save(shop);
    }

    @PostMapping("/{id}")
    public Sale update(@PathVariable Long id, @RequestBody Sale details) {
        Sale employee = salesService.getById(id);
        employee.setCoffeeShop(details.getCoffeeShop());
        employee.setSaleDate(details.getSaleDate());
        employee.setEmployee(details.getEmployee());
        employee.setTotalAmount(details.getTotalAmount());
        return salesService.save(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteShop(@PathVariable Long id) {
        salesService.delete(id);
    }
}