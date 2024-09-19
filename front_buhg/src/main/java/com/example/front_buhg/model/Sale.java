package com.example.front_buhg.model;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Sale {


    private Long saleId;


    private CoffeeShop coffeeShop;


    private Employee employee;

    private LocalDateTime saleDate;

    private BigDecimal totalAmount;

    public Sale(CoffeeShop coffeeShop, Employee employee, LocalDateTime saleDate, BigDecimal totalAmount) {
        this.coffeeShop = coffeeShop;
        this.employee = employee;
        this.saleDate = saleDate;
        this.totalAmount = totalAmount;
    }

    public Sale() {

    }

    public CoffeeShop getCoffeeShop() {
        return coffeeShop;
    }

    public void setCoffeeShop(CoffeeShop coffeeShop) {
        this.coffeeShop = coffeeShop;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }
}
