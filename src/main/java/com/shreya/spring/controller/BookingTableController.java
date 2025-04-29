package com.shreya.spring.controller;

import com.shreya.spring.model.BookingTable;
import com.shreya.spring.service.BookingTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tableBookingManagement")
public class BookingTableController {

    @Autowired
    private BookingTableService bookingTableService;

    @PostMapping
    public boolean addBooking(@RequestBody BookingTable bookingTable) throws SQLException {
        return bookingTableService.addBooking(bookingTable);
    }

    @GetMapping("/tableBookings")
    public List<BookingTable> getAllBookings() {
        return bookingTableService.getAllBookings();
    }

    @GetMapping("/tableBooking/{id}")
    public BookingTable getBookingById(@PathVariable Long id) {
        Optional<BookingTable> booking = bookingTableService.getBookingById(id);
        return booking.orElse(null);
    }

    @PutMapping("/tableBooking/{id}")
    public boolean updateBooking(@PathVariable Long id, @RequestBody BookingTable bookingTable) {
        return bookingTableService.updateBooking(id, bookingTable);
    }

    @DeleteMapping("/tableBooking/{id}")
    public boolean deleteBooking(@PathVariable Long id) {
        return bookingTableService.deleteBooking(id);
    }
}
