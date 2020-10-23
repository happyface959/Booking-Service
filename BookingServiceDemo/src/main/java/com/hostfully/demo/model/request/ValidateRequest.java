package com.hostfully.demo.model.request;

import com.hostfully.demo.model.domain.Status;

public class ValidateRequest {
    public static boolean isRequestValid(BookingRequest bookingRequest) {
        switch (bookingRequest.getLeadType()) {
            case INQUIRY:
                return Status.getInquiryStatusList().contains(bookingRequest.getStatus());
            case BOOKING:
                return Status.getBookingStatusList().contains(bookingRequest.getStatus());
            case BLOCK:
                return Status.getBlockStatusList().contains(bookingRequest.getStatus());
        }
        return false;
    }
}
