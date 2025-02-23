package com.crud.service;

import com.crud.model.dto.BookingDTO;
import java.util.List;

public interface BookingService {

    List<BookingDTO> loadAllBookings();

    void saveBooking(BookingDTO booking);

    BookingDTO getBookingById(Long id);

    List<BookingDTO> findBookingsByUserId(Long userId);

    List<BookingDTO> findBookingsByFlightId(Long flightId);
}
