package com.example.buhg_rest.controller;

import com.example.buhg_rest.model.Expense;
import com.example.buhg_rest.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/expense")
public class ExpenseController {

    @Autowired
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }


    @GetMapping
    public List<Expense> getAll() {
        return expenseService.getAll();
    }

    @GetMapping("/{id}")
    public Expense getById(@PathVariable Long id) {
        return expenseService.getById(id);
    }

    @PostMapping
    public Expense create(@RequestBody Expense shop) {
        return expenseService.save(shop);
    }

    @PostMapping("/{id}")
    public Expense update(@PathVariable Long id, @RequestBody Expense details) {
        Expense employee = expenseService.getById(id);
        employee.setCoffeeShop(details.getCoffeeShop());
        employee.setAmount(details.getAmount());
        employee.setDescription(details.getDescription());
        employee.setExpenseDate(details.getExpenseDate());
        return expenseService.save(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteShop(@PathVariable Long id) {
        expenseService.delete(id);
    }
}