package com.example.backend.Service.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.booking.Booking;
import com.example.backend.model.booking.Room;

import java.util.Date;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Room> checkAvailability(Date startDate, Date endDate) {
        // code to check availibility
        List<Booking> bookings = bookingRepository.findStartDateBetween(startDate, endDate);

        bookings.addAll(bookingRepository.findEndDateBetween(startDate, endDate));

        bookings.addAll(bookingRepository.findStartDateLessThanEqualAndEndDateGreaterThanEqual(startDate, endDate));
        // code to filter avaiulable rooms
        return null;
    }

    public Booking bookRoom(Booking booking) {
        return bookingRepository.save(booking);
    }

    public double getPrice(Long roomId, Date startDate, Date endDate) {
        // code to get price
        return 0.0;
    }
}
