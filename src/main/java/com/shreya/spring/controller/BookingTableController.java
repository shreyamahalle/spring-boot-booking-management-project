package com.shreya.spring.controller;

import com.shreya.spring.model.BookingTable;
import com.shreya.spring.service.BookingTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/tableBookingManagement")
public class BookingTableController {

    @Autowired
    private BookingTableService bookingTableService;

    @PostMapping("/tableBooking")
    public boolean addBooking(@RequestBody BookingTable bookingTable) throws SQLException {
        return bookingTableService.addBooking(bookingTable);
    }

    @GetMapping("/tableBookings")
    public List<BookingTable> getAllBookings() {
        return bookingTableService.getAllBookings();
    }

    @GetMapping("/tableBooking/{id}")
    public BookingTable getBookingById(@PathVariable("id") Long id) {
        System.out.println("Inside controller " + getBookingById(id));
        return bookingTableService.getBookingById(id);
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