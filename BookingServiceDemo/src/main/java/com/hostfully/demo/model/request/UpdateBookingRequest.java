package com.hostfully.demo.model.request;

import com.hostfully.demo.model.domain.LeadType;
import com.hostfully.demo.model.domain.Status;

import java.time.Instant;
import java.util.UUID;

public class UpdateBookingRequest extends BookingRequest {
    private UUID bookingId;

    public UpdateBookingRequest(UUID bookingId, Instant checkInDate, Instant checkOutDate, UUID agencyId, LeadType leadType, Status status, UUID propertyId) {
        super(checkInDate, checkOutDate, agencyId, leadType, status, propertyId);
        this.bookingId = bookingId;
    }

    public UpdateBookingRequest() {};

    public UUID getBookingId() {
        return bookingId;
    }

    public void setBookingId(UUID bookingId) {
        this.bookingId = bookingId;
    }
}
