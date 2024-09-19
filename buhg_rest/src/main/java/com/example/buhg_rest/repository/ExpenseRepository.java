package com.example.buhg_rest.repository;

import com.example.buhg_rest.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}