package com.hostfully.demo.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Property {
    private String address;
    private List<OccupiedRange> occupiedDates = new ArrayList<>();

    public boolean availableDateRange(OccupiedRange requestedRange) {
        for (var existingRange : occupiedDates) {
            if (existingRange.getStartingDate().isBefore(requestedRange.getEndingDate()) &&
                requestedRange.getStartingDate().isBefore(existingRange.getEndingDate())) {
                return false;
            }
        }
        return true;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OccupiedRange> getOccupiedDates() {
        return occupiedDates;
    }

    public void setOccupiedDates(List<OccupiedRange> occupiedDates) {
        this.occupiedDates = occupiedDates;
    }
}
