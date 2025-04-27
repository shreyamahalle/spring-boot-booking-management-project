package com.shreya.spring.repository;

import com.shreya.spring.model.BookingTable;
import com.shreya.spring.service.ConnectionService;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookingTableRepository {

    public boolean addBooking(BookingTable bookingTable) {
        if (bookingTable.getCustomerName() == null || bookingTable.getCustomerName().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be null or empty.");
        }

        // Format the booking time to a string (Adjust format if needed)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedBookingTime = bookingTable.getBookingTime().format(formatter);

        String query = "INSERT INTO booking_table (customer_name, restaurant_name, booking_time, number_of_people, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            // Set parameters
            ps.setString(1, bookingTable.getCustomerName());
            ps.setString(2, bookingTable.getRestaurantName());
            ps.setString(3, formattedBookingTime);  // Set formatted booking time
            ps.setInt(4, bookingTable.getNumberOfPeople());
            ps.setString(5, bookingTable.getStatus());

            // Execute query
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;  // Return true if a row was inserted
        } catch (SQLException e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            // Optionally, throw a custom exception or return false if necessary
            return false;
        }
    }
    public List<BookingTable> retrieveBookings() {
        List<BookingTable> bookings = new ArrayList<>();
        String query = "SELECT * FROM booking_table";

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                BookingTable booking = new BookingTable(
                        rs.getLong("id"),
                        rs.getString("customer_name"),
                        rs.getString("restaurant_name"),
                        rs.getTime("booking_time"),
                        rs.getInt("number_of_people"),
                        rs.getString("status")
                );
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    public Optional<BookingTable> findById(Long id) {
        String query = "SELECT * FROM booking_table WHERE id = ?";
        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    BookingTable bookingTable = new BookingTable(
                            rs.getLong("id"),
                            rs.getString("customer_name"),
                            rs.getString("restaurant_name"),
                            Time.valueOf(rs.getString("booking_time")),
                            rs.getInt("number_of_people"),
                            rs.getString("status")
                    );
                    return Optional.of(bookingTable);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public boolean deleteBooking(Long id) {
        String query = "DELETE FROM booking_table WHERE id = ?";
        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setLong(1, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateBooking(BookingTable bookingTable) {
        String query = "UPDATE booking_table SET customer_name = ?, restaurant_name = ?, booking_time = ?, number_of_people = ?, status = ? WHERE id = ?";
        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, bookingTable.getCustomerName());
            ps.setString(2, bookingTable.getRestaurantName());
            ps.setString(3, String.valueOf(bookingTable.getBookingTime()));
            ps.setInt(4, bookingTable.getNumberOfPeople());
            ps.setString(5, bookingTable.getStatus());
            ps.setLong(6, bookingTable.getId());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
