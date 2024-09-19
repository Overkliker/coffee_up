package com.example.front_buhg.model;



import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Payment {


    private Long paymentId;

    private Sale sale;

    private LocalDateTime paymentDate;

    private String paymentMethod;
    private BigDecimal amount;

    public Payment(Sale sale, LocalDateTime paymentDate, String paymentMethod, BigDecimal amount) {
        this.sale = sale;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    public Payment() {

    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }
}