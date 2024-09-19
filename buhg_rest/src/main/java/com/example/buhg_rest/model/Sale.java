package com.example.buhg_rest.model;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long saleId;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private CoffeeShop coffeeShop;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime saleDate;

    @Column(nullable = false)
    private BigDecimal totalAmount;

    public Sale(CoffeeShop coffeeShop, Employee employee, LocalDateTime saleDate, BigDecimal totalAmount) {
        this.coffeeShop = coffeeShop;
        this.employee = employee;
        this.saleDate = saleDate;
        this.totalAmount = totalAmount;
    }

    public Sale() {

    }

    public Sale(Long saleId, CoffeeShop coffeeShop, Employee employee, LocalDateTime saleDate, BigDecimal totalAmount) {
        this.saleId = saleId;
        this.coffeeShop = coffeeShop;
        this.employee = employee;
        this.saleDate = saleDate;
        this.totalAmount = totalAmount;
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
