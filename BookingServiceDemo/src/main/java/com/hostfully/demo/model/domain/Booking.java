package com.hostfully.demo.model.domain;

import com.hostfully.demo.model.request.UpdateBookingRequest;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class Booking {
    private UUID id;
    private Instant checkInDate;
    private Instant checkOutDate;
    private UUID agencyId;
    private LeadType leadType;
    private Status status;
    private UUID propertyId;

    public Booking(UUID id, Instant checkInDate, Instant checkOutDate, UUID agencyId, LeadType leadType, Status status, UUID propertyId) {
        this.id = id;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.agencyId = agencyId;
        this.leadType = leadType;
        this.status = status;
        this.propertyId = propertyId;
    }

    public Booking() {}

    public void update(UpdateBookingRequest updateBookingRequest) {
        checkInDate = updateBookingRequest.getCheckInDate();
        checkOutDate = updateBookingRequest.getCheckOutDate();
        agencyId = updateBookingRequest.getAgencyId();
        leadType = updateBookingRequest.getLeadType();
        status = updateBookingRequest.getStatus();
        propertyId = updateBookingRequest.getPropertyId();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id) &&
                Objects.equals(checkInDate, booking.checkInDate) &&
                Objects.equals(checkOutDate, booking.checkOutDate) &&
                Objects.equals(agencyId, booking.agencyId) &&
                leadType == booking.leadType &&
                status == booking.status &&
                Objects.equals(propertyId, booking.propertyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, checkInDate, checkOutDate, agencyId, leadType, status, propertyId);
    }
}