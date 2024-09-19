package com.example.buhg_rest.model;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class SaleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long saleItemId;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;
    private BigDecimal subtotal;

    public SaleItem(Sale sale, Product product, Integer quantity, BigDecimal subtotal) {
        this.sale = sale;
        this.product = product;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public SaleItem() {

    }

    public SaleItem(Long saleItemId, Sale sale, Product product, Integer quantity, BigDecimal subtotal) {
        this.saleItemId = saleItemId;
        this.sale = sale;
        this.product = product;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Long getSaleItemId() {
        return saleItemId;
    }

    public void setSaleItemId(Long saleItemId) {
        this.saleItemId = saleItemId;
    }
}