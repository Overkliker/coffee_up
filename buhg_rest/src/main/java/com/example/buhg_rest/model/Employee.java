package com.example.buhg_rest.model;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private CoffeeShop coffeeShop;

    @Column(nullable = false)
    private String name;

    private String position;
    private LocalDate hireDate;
    private BigDecimal salary;

    public Employee(CoffeeShop coffeeShop, String name, String position, LocalDate hireDate, BigDecimal salary) {
        this.coffeeShop = coffeeShop;
        this.name = name;
        this.position = position;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public Employee() {

    }

    public Employee(Long employeeId, CoffeeShop coffeeShop, String name, String position, LocalDate hireDate, BigDecimal salary) {
        this.employeeId = employeeId;
        this.coffeeShop = coffeeShop;
        this.name = name;
        this.position = position;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public CoffeeShop getCoffeeShop() {
        return coffeeShop;
    }

    public void setCoffeeShop(CoffeeShop coffeeShop) {
        this.coffeeShop = coffeeShop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}