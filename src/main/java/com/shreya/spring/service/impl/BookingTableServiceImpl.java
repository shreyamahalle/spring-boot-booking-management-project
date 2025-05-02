package com.shreya.spring.service.impl;

import com.shreya.spring.model.BookingTable;
import com.shreya.spring.repository.BookingTableRepository;
import com.shreya.spring.service.BookingTableService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor

public class BookingTableServiceImpl implements BookingTableService {

    @Autowired
    private final BookingTableRepository bookingTableRepository;

    @Override
    public boolean addBooking(BookingTable bookingTable) throws SQLException {
        return bookingTableRepository.addBooking(bookingTable);
    }

    @Override
    public List<BookingTable> getAllBookings() {
        return bookingTableRepository.retrieveBookings();
    }

    @Override
    public BookingTable getBookingById(Long id) {
        return bookingTableRepository.findById(id);
    }

    @Override
    public boolean deleteBooking(Long id) {
        return bookingTableRepository.deleteBooking(id);
    }

    @Override
    public boolean updateBooking(long id, BookingTable bookingTable) {
        return bookingTableRepository.updateBooking(bookingTable);
    }
}
