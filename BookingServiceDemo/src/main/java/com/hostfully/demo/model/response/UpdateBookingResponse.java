package com.hostfully.demo.model.response;

import com.hostfully.demo.model.domain.Booking;

public class UpdateBookingResponse extends BookingResponse {
    public UpdateBookingResponse(Booking booking) {
        super(booking);
    }

    public UpdateBookingResponse(String message) {
        super(message);
    }
}