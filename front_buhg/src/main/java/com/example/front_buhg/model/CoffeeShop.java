package com.example.front_buhg.model;


public class CoffeeShop {

    private Long shopId;

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