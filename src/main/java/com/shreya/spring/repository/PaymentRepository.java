package com.shreya.spring.repository;

import com.shreya.spring.model.Order;
import com.shreya.spring.model.Payment;
import com.shreya.spring.service.ConnectionService;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class PaymentRepository {

    public boolean addPayment(Payment payment) throws SQLException {
        String query = "INSERT INTO payment(id,orderrid, amount, payment_method, payment_status,transaction_id )VALUES (?, ?, ?, ?, ?, ?)";

        try(Connection connection = ConnectionService.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setLong(1, payment.getId());
            ps.setInt(2, payment.getOrder().getId());
            ps.setDouble(3, payment.getAmount());
            ps.setString(4, payment.getPaymentMethod());
            ps.setString(5, payment.getPaymentStatus());
            ps.setString(6, payment.getTransactionId());
            return ps.executeUpdate() > 0;
        }
    catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Payment> findAll() throws SQLException {
        String query = "SELECT * FROM payment";
        List<Payment> payments = new ArrayList<>();
        try (Connection con = ConnectionService.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                payments.add(Payment.builder()
                        .id(rs.getLong("id"))
                        .order(Order.builder().id(rs.getInt("orderrid")).build())
                        .amount(rs.getDouble("amount"))
                        .paymentMethod(rs.getString("payment_method"))
                        .paymentStatus(rs.getString("payment_status"))
                        .transactionId(rs.getString("transaction_id"))
                        .build());
            }
        }
        return payments;
    }

    public Payment findById(int id) throws SQLException {
        String query = "SELECT * FROM payment WHERE id = ?";
        try (Connection con = ConnectionService.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Payment.builder()
                        .id(rs.getLong("id"))
                        .order(Order.builder().id(rs.getInt("orderrid")).build())
                        .amount(rs.getDouble("amount"))
                        .paymentMethod(rs.getString("payment_method"))
                        .paymentStatus(rs.getString("payment_status"))
                        .transactionId(rs.getString("transaction_id"))
                        .build();
            }
        }
        return null;
    }

    public boolean update(Payment payment) throws SQLException {
        String query = "UPDATE payment SET orderrid=?, amount=?, payment_method=?, payment_status=?, transaction_id=? WHERE id=?";
        try (Connection con = ConnectionService.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, payment.getOrder().getId());
            ps.setDouble(2, payment.getAmount());
            ps.setString(3, payment.getPaymentMethod());
            ps.setString(4, payment.getPaymentStatus());
            ps.setString(5, payment.getTransactionId());
            ps.setInt(6, Math.toIntExact(payment.getId()));
            return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(int id) throws SQLException {
        String query = "DELETE FROM payment WHERE id = ?";
        try (Connection con = ConnectionService.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
