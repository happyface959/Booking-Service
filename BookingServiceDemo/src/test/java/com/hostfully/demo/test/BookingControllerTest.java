package com.hostfully.demo.test;

import com.hostfully.demo.api.PropertyService;
import com.hostfully.demo.model.domain.Booking;
import com.hostfully.demo.model.domain.LeadType;
import com.hostfully.demo.model.domain.Status;
import com.hostfully.demo.model.request.CreateBookingRequest;
import com.hostfully.demo.model.request.UpdateBookingRequest;
import com.hostfully.demo.repository.BookingRepository;
import com.hostfully.demo.repository.Repository;
import com.hostfully.demo.service.BookingService;
import com.hostfully.demo.service.Service;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Singleton;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.Instant;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

class BookingControllerTest extends JerseyTest {
    private static final String PATH = "booking-service/booking/";

    @BeforeEach
    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @AfterEach
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Override
    protected Application configure() {
        return new ResourceConfig(BookingController.class)
            .register(new AbstractBinder() {
                @Override
                protected void configure() {
                    bind(BookingService.class).to(Service.class).in(Singleton.class);
                    bind(BookingRepository.class).to(Repository.class).in(Singleton.class);
                    bind(PropertyServiceTestImpl.class).to(PropertyService.class).in(Singleton.class);
                }
            })
            .packages("com.hostfully.demo");
    }

    @Test
    void getBookingShouldSucceed() {
        var bookingId = UUID.randomUUID();
        var booking = target(PATH + bookingId)
            .request()
            .get(Booking.class);
        assertEquals(bookingId, booking.getId());
    }

    @Test
    void postBookingShouldFailBadRequest() {
        var createBookingRequest = new CreateBookingRequest(
            Instant.now(),
            Instant.now(),
            UUID.randomUUID(),
            LeadType.BOOKING,
            Status.NEW,
            UUID.randomUUID()
        );
        var response = target(PATH).request(MediaType.APPLICATION_JSON_TYPE)
            .post(Entity.entity(createBookingRequest, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(400, response.getStatus());
    }

    @Test
    void postBookingShouldSucceed() {
        var createBookingRequest = new CreateBookingRequest(
            Instant.now(),
            Instant.now(),
            UUID.randomUUID(),
            LeadType.INQUIRY,
            Status.NEW,
            UUID.randomUUID()
        );
        var response = target(PATH).request()
            .post(Entity.entity(createBookingRequest, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(201, response.getStatus());
    }

    @Test
    void putBookingShouldFailBadRequest() {
        var updateBookingRequest = new UpdateBookingRequest(
            UUID.randomUUID(),
            Instant.now(),
            Instant.now(),
            UUID.randomUUID(),
            LeadType.BOOKING,
            Status.NEW,
            UUID.randomUUID()
        );
        var response = target(PATH).request()
            .put(Entity.entity(updateBookingRequest, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(400, response.getStatus());
    }

    @Test
    void putBookingShouldSucceed() {
        var updateBookingRequest = new UpdateBookingRequest(
            UUID.randomUUID(),
            Instant.now(),
            Instant.now(),
            UUID.randomUUID(),
            LeadType.INQUIRY,
            Status.NEW,
            UUID.randomUUID()
        );
        var response = target(PATH).request()
            .put(Entity.entity(updateBookingRequest, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(200, response.getStatus());
    }

    @Test
    void deleteBookingShouldSucceed() {
        var bookingId = UUID.randomUUID();
        var response = target(PATH + bookingId)
            .request()
            .delete();
        assertEquals(204, response.getStatus());
    }

    @Test
    void pingShouldSucceed() {
        var response = target("booking-service/status/ping").request().get(Response.class);
        assertEquals(200, response.getStatus());
    }
}