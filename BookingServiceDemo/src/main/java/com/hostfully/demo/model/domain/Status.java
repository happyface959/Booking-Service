package com.hostfully.demo.model.domain;

import java.util.List;

public enum Status {
    BLOCKED,
    NEW,
    ON_HOLD,
    QUOTE_SENT,
    HOLD_EXPIRED,
    CLOSED_QUOTE,
    CLOSED_HOLD,
    BOOKED_BY_AGENT,
    BOOKED_BY_CUSTOMER,
    BOOKED_BY_OWNER,
    BOOKED_EXTERNALLY,
    CANCELLED,
    CANCELLED_BY_TRAVELER,
    CANCELLED_BY_OWNER,
    STAY,
    ARCHIVED;

    public static List<Status> getBlockStatusList() {
        return List.of(Status.BLOCKED);
    }

    public static List<Status> getInquiryStatusList() {
        return List.of(
            Status.NEW,
            Status.ON_HOLD,
            Status.QUOTE_SENT,
            Status.HOLD_EXPIRED,
            Status.CLOSED_QUOTE,
            Status.CLOSED_HOLD
        );
    }

    public static List<Status> getBookingStatusList() {
        return List.of(
            BOOKED_BY_AGENT,
            BOOKED_BY_CUSTOMER,
            BOOKED_BY_OWNER,
            BOOKED_EXTERNALLY,
            CANCELLED,
            CANCELLED_BY_TRAVELER,
            CANCELLED_BY_OWNER,
            STAY,
            ARCHIVED
        );
    }
}