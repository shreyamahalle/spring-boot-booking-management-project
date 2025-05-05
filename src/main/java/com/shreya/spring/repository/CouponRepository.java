package com.shreya.spring.repository;

import com.shreya.spring.model.Coupon;
import com.shreya.spring.service.ConnectionService;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CouponRepository {

    public boolean saveCoupon(Coupon coupon) throws SQLException {
        String query = "INSERT INTO coupon (code, description, discount_amount, active) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionService.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, coupon.getCode());
            ps.setString(2, coupon.getDescription());
            ps.setDouble(3, coupon.getDiscountAmount());
            ps.setBoolean(4, coupon.isActive());

            return ps.executeUpdate() > 0;
        }
    }

    public List<Coupon> getAllCoupons() {
        List<Coupon> coupons = new ArrayList<>();
        String query = "SELECT * FROM coupon";

        try (Connection conn = ConnectionService.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                coupons.add(new Coupon(
                        rs.getLong("id"),
                        rs.getString("code"),
                        rs.getString("description"),
                        rs.getDouble("discount_amount"),
                        rs.getBoolean("active")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return coupons;
    }

    public Coupon getCouponById(Long id) {
        String query = "SELECT * FROM coupon WHERE id = ?";

        try (Connection conn = ConnectionService.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Coupon(
                            rs.getLong("id"),
                            rs.getString("code"),
                            rs.getString("description"),
                            rs.getDouble("discount_amount"),
                            rs.getBoolean("active")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean deleteCoupon(Long id) {
        String query = "DELETE FROM coupon WHERE id = ?";

        try (Connection conn = ConnectionService.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setLong(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateCoupon(Coupon coupon) {
        String query = "UPDATE coupon SET code = ?, description = ?, discount_amount = ?, active = ? WHERE id = ?";

        try (Connection conn = ConnectionService.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, coupon.getCode());
            ps.setString(2, coupon.getDescription());
            ps.setDouble(3, coupon.getDiscountAmount());
            ps.setBoolean(4, coupon.isActive());
            ps.setLong(5, coupon.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
