package com.shreya.spring.service;

import com.shreya.spring.model.Payment;
import com.shreya.spring.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public boolean addPayment(Payment payment) throws SQLException {
        return paymentRepository.addPayment(payment);
    }

    public List<Payment> getAllPayments() throws SQLException {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(int id) throws SQLException {
        return paymentRepository.findById(id);
    }

    public boolean updatePayment(Payment payment) throws SQLException {
        return paymentRepository.update(payment);
    }

    public boolean deletePayment(int id) throws SQLException {
        return paymentRepository.delete(id);
    }
}
