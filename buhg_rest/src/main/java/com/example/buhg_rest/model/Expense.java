package com.example.buhg_rest.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
public class Expense {

    public Expense(Long expenseId, CoffeeShop coffeeShop, LocalDate expenseDate, String description, BigDecimal amount) {
        this.expenseId = expenseId;
        this.coffeeShop = coffeeShop;
        this.expenseDate = expenseDate;
        this.description = description;
        this.amount = amount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private CoffeeShop coffeeShop;

    private LocalDate expenseDate;
    private String description;
    private BigDecimal amount;

    public Expense(CoffeeShop coffeeShop, LocalDate expenseDate, String description, BigDecimal amount) {
        this.coffeeShop = coffeeShop;
        this.expenseDate = expenseDate;
        this.description = description;
        this.amount = amount;
    }

    public Expense() {

    }

    public CoffeeShop getCoffeeShop() {
        return coffeeShop;
    }

    public void setCoffeeShop(CoffeeShop coffeeShop) {
        this.coffeeShop = coffeeShop;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Long expenseId) {
        this.expenseId = expenseId;
    }
}
