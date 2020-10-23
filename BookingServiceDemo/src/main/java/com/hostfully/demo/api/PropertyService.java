package com.hostfully.demo.api;

import com.hostfully.demo.exception.BookingException;
import com.hostfully.demo.model.domain.Booking;

public interface PropertyService {
    boolean canBookProperty(Booking booking) throws BookingException;
}
