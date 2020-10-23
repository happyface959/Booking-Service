package com.hostfully.demo.test;

import com.hostfully.demo.exception.BookingException;
import com.hostfully.demo.model.request.CreateBookingRequest;
import com.hostfully.demo.model.request.UpdateBookingRequest;
import com.hostfully.demo.model.request.ValidateRequest;
import com.hostfully.demo.service.Service;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/booking-service")
public class BookingController {
    @Inject
    Service service;

    @GET
    @Path("/booking/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBooking(@PathParam("id") UUID bookingId) throws BookingException {
        var booking = service.readBooking(bookingId);
        return Response.ok().entity(booking).build();
    }

    @POST
    @Path("/booking")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postBooking(CreateBookingRequest createBookingRequest) throws BookingException {
        if (!ValidateRequest.isRequestValid(createBookingRequest)) {
            return Response.status(400).entity("Request Validation Failed").build();
        }
        var createBookingResponse = service.createBooking(createBookingRequest);
        var statusCode = createBookingResponse.success ? 201 : 500;
        return Response.status(statusCode).entity(createBookingResponse).build();
    }

    @PUT
    @Path("/booking")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putBooking(UpdateBookingRequest updateBookingRequest) throws BookingException {
        if (!ValidateRequest.isRequestValid(updateBookingRequest)) {
            return Response.status(400).entity("Request Validation Failed").build();
        }
        var updateBookingResponse = service.updateBooking(updateBookingRequest);
        return Response.ok().entity(updateBookingResponse).build();
    }

    @DELETE
    @Path("/booking/{id}")
    public Response deleteBooking(@PathParam("id") UUID bookingId) throws BookingException {
        service.deleteBooking(bookingId);
        return Response.status(204).entity("Booking Successfully Deleted").build();
    }

    @GET
    @Path("/status/ping")
    public Response ping() {
        return Response.ok().entity("Service Online").build();
    }
}