package com.hostfully.demo.api;

import com.hostfully.demo.exception.BookingException;
import com.hostfully.demo.model.domain.Booking;
import com.hostfully.demo.model.domain.OccupiedRange;
import com.hostfully.demo.model.domain.Property;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class PropertyServiceImpl implements PropertyService {
    @Override
    public boolean canBookProperty(Booking booking) throws BookingException {
        var client = ClientBuilder.newClient();
        var webTarget = client.target("http://localhost:8080/property-service/property/" + booking.getPropertyId());
        var invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Property property;
        try {
            property = invocationBuilder.get(Property.class);
        } catch (ProcessingException | WebApplicationException e) {
            throw new BookingException("Unable to get property info" + e.getMessage());
        }
        return property.availableDateRange(new OccupiedRange(booking.getCheckInDate(), booking.getCheckOutDate()));
    }
}
