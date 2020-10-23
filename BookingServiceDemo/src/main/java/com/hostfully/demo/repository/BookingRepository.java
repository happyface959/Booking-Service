package com.hostfully.demo.repository;

import com.hostfully.demo.exception.BookingException;
import com.hostfully.demo.model.data.BookingEntity;
import com.hostfully.demo.model.domain.Booking;
import com.hostfully.demo.model.domain.LeadType;
import com.hostfully.demo.model.domain.Status;

import java.sql.SQLException;
import java.time.Instant;
import java.util.UUID;

public class BookingRepository implements Repository {
    @Override
    public void createBooking(Booking booking) throws BookingException {
        var sql = "INSERT INTO Booking VALUES ('%s', '%s', '%s', '%s', '%s')";
        sql = String.format(
            sql,
            booking.getCheckInDate().getEpochSecond(),
            booking.getCheckOutDate().getEpochSecond(),
            booking.getLeadType(),
            booking.getStatus(),
            booking.getAgencyId()
        );
        //var statement = connection.createStatement();
        try {
            //statement.executeUpdate(sql);*/
            if (sql == null) { //executeUpdate can throw a SQLException, since JDBC is not hooked up, I added a throws here
                throw new SQLException();
            }
        } catch (SQLException exception) {
            throw new BookingException("Unable to create booking: " + exception.getMessage());
        }
    }

    @Override
    public Booking readBooking(UUID bookingId) throws BookingException {
        var sql = "SELECT * FROM Booking WHERE id = '%s'";
        sql = String.format(sql, bookingId);
        //var statement = connection.createStatement();
        try {
            //statement.executeUpdate(sql);
            if (sql == null) { //executeUpdate can throw a SQLException, since JDBC is not hooked up, I added a throws here
                throw new SQLException();
            }
        } catch (SQLException exception) {
            throw new BookingException("Unable to read booking: " + exception.getMessage());
        }
        //returned data entity from db
        var dataEntity = new BookingEntity(
            bookingId,
            Instant.now(),
            Instant.now(),
            UUID.randomUUID(),
            LeadType.INQUIRY,
            Status.NEW,
            UUID.randomUUID()
        );
        //map data entity to domain model
        return new Booking(
            dataEntity.getId(),
            dataEntity.getCheckInDate(),
            dataEntity.getCheckOutDate(),
            dataEntity.getAgencyId(),
            dataEntity.getLeadType(),
            dataEntity.getStatus(),
            dataEntity.getPropertyId()
        );
    }

    @Override
    public void updateBooking(Booking booking) throws BookingException {
        var sql = "UPDATE Booking SET CheckInDate='%s', CheckOutDate='%s' WHERE Id = %s";
        sql = String.format(
            sql,
            booking.getCheckInDate(),
            booking.getCheckOutDate(),
            booking.getId()
        );
        //var statement = connection.createStatement();
        try {
            //statement.executeUpdate(sql);
            if (sql == null) { //executeUpdate can throw a SQLException, since JDBC is not hooked up, I added a throws here
                throw new SQLException();
            }
        } catch (SQLException exception) {
            throw new BookingException("Unable to update booking: " + exception.getMessage());
        }
    }

    @Override
    public void deleteBooking(UUID bookingId) throws BookingException {
        var sql = "DELETE Booking WHERE ID = '%s'";
        sql = String.format(sql, bookingId);
        //var statement = connection.createStatement();
        try {
            //statement.executeUpdate(sql);
            if (sql == null) { //executeUpdate can throw a SQLException, since JDBC is not hooked up, I added a throws here
                throw new SQLException();
            }
        } catch (SQLException exception) {
            throw new BookingException("Unable to delete booking: " + exception.getMessage());
        }
    }
}