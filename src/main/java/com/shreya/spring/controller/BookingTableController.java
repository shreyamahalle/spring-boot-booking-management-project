package com.shreya.spring.controller;

import com.shreya.spring.model.BookingTable;
import com.shreya.spring.service.BookingTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/tableBookingManagement")

public class BookingTableController {

    private static final Logger log = LoggerFactory.getLogger(BookingTableController.class);

    @Autowired
    private BookingTableService bookingTableService;

    @PostMapping("/tableBooking")
    public boolean addBooking(@RequestBody BookingTable bookingTable) throws SQLException {
        log.info("API called: add booking {}", bookingTable);
        return bookingTableService.addBooking(bookingTable);
    }

    @GetMapping("/tableBookings")
    public List<BookingTable> getAllBookings() {
        log.info("API called: all bookings");
        return bookingTableService.getAllBookings();
    }

    @GetMapping("/tableBooking/{id}")
    public BookingTable getBookingById(@PathVariable("id") Long id) {
        log.info("API called: get by id {}" , id);
        return bookingTableService.getBookingById(id);
    }

    @PutMapping("/tableBooking/{id}")
    public boolean updateBooking(@PathVariable Long id, @RequestBody BookingTable bookingTable) {
        log.info("API called: update booking {} ",id,bookingTable);
        return bookingTableService.updateBooking(id, bookingTable);
    }

    @DeleteMapping("/tableBooking/{id}")
    public boolean deleteBooking(@PathVariable Long id) {
        log.info("API called: delete by id {}", id);
        return bookingTableService.deleteBooking(id);
    }
}