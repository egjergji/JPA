package com.crud.mapper;

import com.crud.model.dto.BookingDTO;
import com.crud.model.entity.Booking;

public class BookingMapper extends AbstractMapper<Booking, BookingDTO> {

    @Override
    public Booking toEntity(BookingDTO bookingDTO) {
        if (bookingDTO == null) {
            return null;
        }
        Booking booking = new Booking();
        booking.setId(bookingDTO.getId());
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setStatus(bookingDTO.getStatus());
        return booking;
    }

    @Override
    public BookingDTO toDto(Booking booking) {
        if (booking == null) {
            return null;
        }
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(booking.getId());
        bookingDTO.setBookingDate(booking.getBookingDate());
        bookingDTO.setStatus(booking.getStatus());
        return bookingDTO;
    }
}
