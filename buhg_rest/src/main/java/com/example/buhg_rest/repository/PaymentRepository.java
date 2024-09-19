package com.example.buhg_rest.repository;

import com.example.buhg_rest.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
