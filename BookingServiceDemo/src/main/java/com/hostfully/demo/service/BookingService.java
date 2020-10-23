package com.hostfully.demo.service;

import com.hostfully.demo.api.PropertyService;
import com.hostfully.demo.exception.BookingException;
import com.hostfully.demo.model.domain.Booking;
import com.hostfully.demo.model.request.CreateBookingRequest;
import com.hostfully.demo.model.request.UpdateBookingRequest;
import com.hostfully.demo.model.response.CreateBookingResponse;
import com.hostfully.demo.model.response.UpdateBookingResponse;
import com.hostfully.demo.repository.Repository;

import javax.inject.Inject;
import java.util.UUID;

public class BookingService implements Service {
    @Inject
    Repository repository;
    @Inject
    PropertyService propertyService;

    @Override
    public CreateBookingResponse createBooking(CreateBookingRequest createBookingRequest) throws BookingException {
        var booking = new Booking(
            UUID.randomUUID(),
            createBookingRequest.getCheckInDate(),
            createBookingRequest.getCheckOutDate(),
            createBookingRequest.getAgencyId(),
            createBookingRequest.getLeadType(),
            createBookingRequest.getStatus(),
            createBookingRequest.getPropertyId()
        );
        if (!propertyService.canBookProperty(booking)) {
            return new CreateBookingResponse("The requested date range is all ready taken");
        }
        try {
            repository.createBooking(booking);
        } catch (BookingException e) {
            return new CreateBookingResponse(e.getMessage());
        }
        return new CreateBookingResponse(booking);
    }

    @Override
    public Booking readBooking(UUID bookingId) throws BookingException {
        return repository.readBooking(bookingId);
    }

    @Override
    public UpdateBookingResponse updateBooking(UpdateBookingRequest updateBookingRequest) throws BookingException {
        var booking = repository.readBooking(updateBookingRequest.getBookingId());
        if (!propertyService.canBookProperty(booking)) {
            return new UpdateBookingResponse("The requested date range is all ready taken");
        }
        booking.update(updateBookingRequest);
        repository.updateBooking(booking);
        return new UpdateBookingResponse(booking);
    }

    @Override
    public void deleteBooking(UUID bookingId) throws BookingException {
        repository.deleteBooking(bookingId);
    }
}