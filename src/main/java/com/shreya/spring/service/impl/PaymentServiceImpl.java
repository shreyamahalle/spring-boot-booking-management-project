package com.shreya.spring.service.impl;

import com.shreya.spring.model.Payment;
import com.shreya.spring.repository.PaymentRepository;
import com.shreya.spring.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public boolean addPayment(Payment payment) throws SQLException {
        return paymentRepository.addPayment(payment);
    }

    @Override
    public List<Payment> getAllPayments() throws SQLException {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(int id) throws SQLException {
        return paymentRepository.findById(id);
    }

    @Override
    public boolean updatePayment(Payment payment) throws SQLException {
        return paymentRepository.update(payment);
    }

    @Override
    public boolean deletePayment(int id) throws SQLException {
        return paymentRepository.delete(id);
    }
}
