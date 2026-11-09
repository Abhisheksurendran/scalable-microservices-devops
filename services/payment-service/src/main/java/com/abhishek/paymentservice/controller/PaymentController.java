package com.abhishek.paymentservice.controller;

import com.abhishek.paymentservice.model.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final List<Payment> payments = new ArrayList<>();

    public PaymentController() {
        payments.add(new Payment(1, 1, 110000, "SUCCESS"));
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return payments;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable int id) {
        return payments.stream()
                .filter(payment -> payment.getId() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        payments.add(payment);
        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }
}
