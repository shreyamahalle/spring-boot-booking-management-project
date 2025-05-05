package com.shreya.spring.repository;

import com.shreya.spring.model.BookingTable;
import com.shreya.spring.service.ConnectionService;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class BookingTableRepository {

    private static final Logger log = LoggerFactory.getLogger(BookingTableRepository.class);

    public boolean addBooking(BookingTable bookingTable) throws SQLException {

        if (bookingTable.getCustomerName() == null || bookingTable.getCustomerName().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be null or empty.");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedBookingTime = bookingTable.getBookingTime().format(formatter);

        String query = "INSERT INTO booking_table (customer_name, restaurant_name, booking_time, number_of_people, status) VALUES (?, ?, ?, ?, ?)";
        log.info("Create booking {}", bookingTable);

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, bookingTable.getCustomerName());
            ps.setString(2, bookingTable.getRestaurantName());
            ps.setString(3, formattedBookingTime);
            ps.setInt(4, bookingTable.getNumberOfPeople());
            ps.setString(5, bookingTable.getStatus());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }

    public List<BookingTable> retrieveBookings() {
        List<BookingTable> bookings = new ArrayList<>();
        String query = "SELECT * FROM booking_table";
        log.info("Retrieve Bookings");

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                BookingTable booking = new BookingTable(
                        rs.getLong("id"),
                        rs.getString("customer_name"),
                        rs.getString("restaurant_name"),
                        // rs.getTime("booking_time"),
                        rs.getTimestamp("booking_time").toLocalDateTime(),
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

    public BookingTable findById(Long id) {
        String query = "SELECT * FROM booking_table WHERE id = ?";
        log.info("Find by id {}", id);

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new BookingTable(
                            rs.getLong("id"),
                            rs.getString("customer_name"),
                            rs.getString("restaurant_name"),
                            rs.getTimestamp("booking_time").toLocalDateTime(),
                            rs.getInt("number_of_people"),
                            rs.getString("status")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteBooking(Long id) {
        String query = "DELETE FROM booking_table WHERE id = ?";
        log.info("Delete booking by id {}", id);

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
        log.info("Update booking {}",bookingTable);

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




//    public boolean updatePartialBookingTable(BookingTable bookingTable) throws SQLException {
//        String query = "UPDATE booking_table SET customer_name = ?, restaurant_name = ?, booking_time = ?, number_of_people = ?, status = ? WHERE id = ?";
//
//        try (Connection connection = ConnectionService.getConnection();
//             PreparedStatement ps = connection.prepareStatement(query)) {
//
//            ps.setString(1, bookingTable.getCustomerName());
//            ps.setString(2, customer.getCity());
//            ps.setInt(3, customer.getMobileNo());
//            ps.setInt(4, customer.getAge());
//            ps.setInt(5, customer.getId());
//
//            int rowsAffected = ps.executeUpdate();
//            return rowsAffected > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
}