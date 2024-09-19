package com.example.buhg_rest.model;
import jakarta.persistence.*;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;

    @ManyToOne
    @JoinColumn(name = "product_id")
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

    public Inventory(Long inventoryId, Product product, Integer quantityInStock, Integer reorderLevel) {
        this.inventoryId = inventoryId;
        this.product = product;
        this.quantityInStock = quantityInStock;
        this.reorderLevel = reorderLevel;
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