package com.example.front_buhg.model;



public class Inventory {


    private Long inventoryId;

    private Product product;

    private Integer quantityInStock;
    private Integer reorderLevel;

    public Inventory(Product product, Integer quantityInStock, Integer reorderLevel) {
        this.product = product;
        this.quantityInStock = quantityInStock;
        this.reorderLevel = reorderLevel;
    }

    public Inventory() {

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Integer getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(Integer reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }
}