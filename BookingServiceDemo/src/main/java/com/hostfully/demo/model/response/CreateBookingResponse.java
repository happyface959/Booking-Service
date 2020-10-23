package com.hostfully.demo.model.response;

import com.hostfully.demo.model.domain.Booking;

public class CreateBookingResponse extends BookingResponse {
    public CreateBookingResponse(Booking booking) {
        super(booking);
    }

    public CreateBookingResponse(String message) {
        super(message);
    }
}