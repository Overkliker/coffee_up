package com.example.buhg_rest.controller;
import com.example.buhg_rest.model.Payment;
import com.example.buhg_rest.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentsController {

    @Autowired
    private final PaymentService paymentService;

    public PaymentsController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @GetMapping
    public List<Payment> getAll() {
        return paymentService.getAll();
    }

    @GetMapping("/{id}")
    public Payment getById(@PathVariable Long id) {
        return paymentService.getById(id);
    }

    @PostMapping
    public Payment create(@RequestBody Payment shop) {
        return paymentService.save(shop);
    }

    @PostMapping("/{id}")
    public Payment update(@PathVariable Long id, @RequestBody Payment details) {
        Payment payment = paymentService.getById(id);
        payment.setPaymentDate(details.getPaymentDate());
        payment.setPaymentMethod(details.getPaymentMethod());
        payment.setAmount(details.getAmount());
        payment.setSale(details.getSale());
        return paymentService.save(payment);
    }

    @DeleteMapping("/{id}")
    public void deleteShop(@PathVariable Long id) {
        paymentService.delete(id);
    }
}
