package com.hostfully.demo.model.request;

import com.hostfully.demo.model.domain.LeadType;
import com.hostfully.demo.model.domain.Status;

import java.time.Instant;
import java.util.UUID;

public class CreateBookingRequest extends BookingRequest {
    public CreateBookingRequest(Instant checkInDate, Instant checkOutDate, UUID agencyId, LeadType leadType, Status status, UUID propertyId) {
        super(checkInDate, checkOutDate, agencyId, leadType, status, propertyId);
    }

    public CreateBookingRequest() {
        super();
    }
}
