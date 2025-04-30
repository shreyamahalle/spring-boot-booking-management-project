package com.shreya.spring.service;

import com.shreya.spring.model.BookingTable;
import com.shreya.spring.repository.BookingTableRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class BookingTableService {

    @Autowired
    private final BookingTableRepository bookingTableRepository;

    public boolean addBooking(BookingTable bookingTable) throws SQLException {
        return bookingTableRepository.addBooking(bookingTable);
    }

    public List<BookingTable> getAllBookings() {
        return bookingTableRepository.retrieveBookings();
    }

    public BookingTable getBookingById(Long id) {
        return bookingTableRepository.findById(id);
    }

    public boolean deleteBooking(Long id) {
        return bookingTableRepository.deleteBooking(id);
    }

    public boolean updateBooking(long id, BookingTable bookingTable) {
        return bookingTableRepository.updateBooking(bookingTable);
    }
}