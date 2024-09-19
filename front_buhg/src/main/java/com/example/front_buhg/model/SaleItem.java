package com.example.front_buhg.model;

import java.math.BigDecimal;


public class SaleItem {


    private Long saleItemId;

    private Sale sale;

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