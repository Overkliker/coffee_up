package com.example.buhg_rest.service;
import com.example.buhg_rest.model.Expense;
import com.example.buhg_rest.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getAll() {
        return expenseRepository.findAll();
    }

    public Expense getById(Long id) {
        return expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Shop not found"));
    }

    public Expense save(Expense shop) {
        return expenseRepository.save(shop);
    }

    public void delete(Long id) {
        expenseRepository.deleteById(id);
    }
}