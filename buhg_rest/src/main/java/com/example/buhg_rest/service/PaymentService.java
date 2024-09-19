package com.example.buhg_rest.service;

import com.example.buhg_rest.model.Payment;
import com.example.buhg_rest.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    public Payment getById(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Shop not found"));
    }

    public Payment save(Payment shop) {
        return paymentRepository.save(shop);
    }

    public void delete(Long id) {
        paymentRepository.deleteById(id);
    }
}