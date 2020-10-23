package com.hostfully.demo.repository;

import com.hostfully.demo.exception.BookingException;
import com.hostfully.demo.model.domain.Booking;
import java.util.UUID;

public interface Repository {
    void createBooking(Booking booking) throws BookingException;
    Booking readBooking(UUID bookingId) throws BookingException;
    void updateBooking(Booking booking) throws BookingException;
    void deleteBooking(UUID bookingId) throws BookingException;
}