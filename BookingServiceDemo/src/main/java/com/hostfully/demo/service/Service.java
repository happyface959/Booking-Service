package com.hostfully.demo.service;

import com.hostfully.demo.exception.BookingException;
import com.hostfully.demo.model.domain.Booking;
import com.hostfully.demo.model.request.CreateBookingRequest;
import com.hostfully.demo.model.request.UpdateBookingRequest;
import com.hostfully.demo.model.response.CreateBookingResponse;
import com.hostfully.demo.model.response.UpdateBookingResponse;

import java.util.UUID;

public interface Service {
    CreateBookingResponse createBooking(CreateBookingRequest createBookingRequest) throws BookingException;
    Booking readBooking(UUID bookingId) throws BookingException;
    UpdateBookingResponse updateBooking(UpdateBookingRequest updateBookingRequest) throws BookingException;
    void deleteBooking(UUID bookingId) throws BookingException;
}