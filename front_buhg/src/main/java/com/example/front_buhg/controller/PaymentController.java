package com.example.front_buhg.controller;

import com.example.front_buhg.model.Payment;
import com.example.front_buhg.model.Sale;
import com.example.front_buhg.service.PaymentApi;
import com.example.front_buhg.service.SaleApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentApi paymentApi;

    @Autowired
    private SaleApi saleApi;

    @GetMapping
    public String getAllPayments(Model model) {
        Payment[] payments = paymentApi.getAll();
        model.addAttribute("payments", payments);
        return "payments/payments";
    }

    @GetMapping("/{id}")
    public String getPaymentById(@PathVariable Long id, Model model) {
        Payment payment = paymentApi.getById(id);
        Sale[] sales = saleApi.getAll();
        model.addAttribute("payment", payment);
        model.addAttribute("sales", sales);
        return "payments/payment";
    }

    @GetMapping("/create")
    public String createPayment(Model model) {
        Sale[] sales = saleApi.getAll();
        model.addAttribute("payment", new Payment());
        model.addAttribute("sales", sales);
        return "payments/createPayment";
    }

    @PostMapping("/create")
    public String savePayment(@RequestParam Long saleId, Payment payment) {
        payment.setSale(saleApi.getById(saleId));
        paymentApi.save(payment);
        return "redirect:/payments";
    }

    @PostMapping("/update/{id}")
    public String updatePayment(@PathVariable Long id, @RequestParam Long saleId,Payment payment) {
        payment.setSale(saleApi.getById(saleId));
        paymentApi.update(payment, id);
        return "redirect:/payments";
    }

    @GetMapping("/delete/{id}")
    public String deletePayment(@PathVariable Long id) {
        paymentApi.delete(id);
        return "redirect:/payments";
    }
}
