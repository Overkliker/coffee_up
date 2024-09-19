package com.example.buhg_rest.model;

import jakarta.persistence.*;

@Entity
public class CoffeeShop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shopId;

    @Column(nullable = false)
    private String name;

    private String location;
    private String phone;
    private String email;

    public CoffeeShop(String name, String location, String phone, String email) {
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
    }

    public CoffeeShop() {

    }

    public CoffeeShop(Long shopId, String name, String location, String phone, String email) {
        this.shopId = shopId;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
}