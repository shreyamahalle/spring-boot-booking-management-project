package com.shreya.spring.controller;

import com.shreya.spring.model.Payment;
import com.shreya.spring.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public boolean addPayment(@RequestBody Payment payment) throws SQLException {
        return paymentService.addPayment(payment);
    }

    @GetMapping
    public List<Payment> getAllPayments() throws SQLException {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable int id) throws SQLException {
        return paymentService.getPaymentById(id);
    }

    @PutMapping("/{id}")
    public boolean updatePayment(@PathVariable int id, @RequestBody Payment payment) throws SQLException {
        payment.setId((long) id);
        return paymentService.updatePayment(payment);
    }

    @DeleteMapping("/{id}")
    public boolean deletePayment(@PathVariable int id) throws SQLException {
        return paymentService.deletePayment(id);
    }
}
