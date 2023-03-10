package com.example.backend.Repositories.Booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.model.booking.Booking;

import java.util.*;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findStartDateBetween(Date startDate, Date endDate);

    List<Booking> findEndDateBetween(Date startDate, Date endDate);

    List<Booking> findStartDateLessThanEqualAndEndDateGreaterThanEqual(Date startDate, Date endDate);
}
