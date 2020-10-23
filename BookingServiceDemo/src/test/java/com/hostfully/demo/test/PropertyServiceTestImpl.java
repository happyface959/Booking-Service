package com.hostfully.demo.test;

import com.hostfully.demo.api.PropertyService;
import com.hostfully.demo.model.domain.Booking;

import javax.enterprise.inject.Alternative;

@Alternative
public class PropertyServiceTestImpl implements PropertyService {
    @Override
    public boolean canBookProperty(Booking booking) {
        return booking.getId() != null;
    }
}