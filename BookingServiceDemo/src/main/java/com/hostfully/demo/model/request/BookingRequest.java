package com.hostfully.demo.model.request;

import com.hostfully.demo.model.domain.LeadType;
import com.hostfully.demo.model.domain.Status;

import java.time.Instant;
import java.util.UUID;

public abstract class BookingRequest {
    private Instant checkInDate;
    private Instant checkOutDate;
    private UUID agencyId;
    private LeadType leadType;
    private Status status;
    private UUID propertyId;

    public BookingRequest(Instant checkInDate, Instant checkOutDate, UUID agencyId, LeadType leadType, Status status, UUID propertyId) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.agencyId = agencyId;
        this.leadType = leadType;
        this.status = status;
        this.propertyId = propertyId;
    }

    public BookingRequest() {}

    public Instant getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Instant checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Instant getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Instant checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public UUID getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(UUID agencyId) {
        this.agencyId = agencyId;
    }

    public LeadType getLeadType() {
        return leadType;
    }

    public void setLeadType(LeadType leadType) {
        this.leadType = leadType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UUID getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(UUID propertyId) {
        this.propertyId = propertyId;
    }
}
