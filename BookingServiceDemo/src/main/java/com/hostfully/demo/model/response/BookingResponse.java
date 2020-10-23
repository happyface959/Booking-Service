package com.hostfully.demo.model.response;

import com.hostfully.demo.model.domain.Booking;

public abstract class BookingResponse {
    public Booking booking;
    public String message;
    public boolean success = true;

    public BookingResponse(Booking booking) {
        this.booking = booking;
    }

    public BookingResponse(String message) {
        this.message = message;
        success = false;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
