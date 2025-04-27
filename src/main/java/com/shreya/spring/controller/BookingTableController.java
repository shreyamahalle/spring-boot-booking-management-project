package com.shreya.spring.controller;

import com.shreya.spring.model.BookingTable;
import com.shreya.spring.service.BookingTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tablebookingmanagement")
public class BookingTableController {

    private final BookingTableService bookingTableService;

    @Autowired
    public BookingTableController(BookingTableService bookingTableService) {
        this.bookingTableService = bookingTableService;
    }
    @PostMapping
    public String bookingTableController (@RequestBody BookingTable bookingTable) throws SQLException {
        bookingTableService.addBooking(bookingTable);
        return bookingTableController(bookingTable);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookingTable>> getAllBookings() {
        List<BookingTable> bookings = bookingTableService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }
    @GetMapping
    public List<BookingTable> getAllCustomers() {
        return bookingTableService.getAllBookings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingTable> getBookingById(@PathVariable Long id) {
        Optional<BookingTable> booking = bookingTableService.getBookingById(id);
        return booking.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body(null));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateBooking(@RequestBody BookingTable bookingTable) {
        boolean success = bookingTableService.updateBooking(bookingTable);
        if (success) {
            return ResponseEntity.ok("Booking updated successfully.");
        } else {
            return ResponseEntity.status(500).body("Failed to update booking.");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long id) {
        boolean success = bookingTableService.deleteBooking(id);
        if (success) {
            return ResponseEntity.ok("Booking deleted successfully.");
        } else {
            return ResponseEntity.status(500).body("Failed to delete booking.");
        }
    }
}
