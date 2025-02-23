package com.crud.service.impl;

import com.crud.mapper.BookingMapper;
import com.crud.model.dto.BookingDTO;
import com.crud.model.entity.Booking;
import com.crud.repository.BookingRepository;
import com.crud.repository.impl.BookingRepositoryImpl;
import com.crud.service.BookingService;
import java.util.List;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    public BookingServiceImpl() {
        this.bookingRepository = new BookingRepositoryImpl();
        this.bookingMapper = new BookingMapper();
    }

    @Override
    public List<BookingDTO> loadAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(bookingMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void saveBooking(BookingDTO bookingDTO) {
        Booking booking = bookingMapper.toEntity(bookingDTO);
        bookingRepository.save(booking);
    }

    @Override
    public BookingDTO getBookingById(Long id) {
        return bookingRepository.findById(id)
                .map(bookingMapper::toDto)
                .orElse(null);
    }

    @Override
    public List<BookingDTO> findBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId)
                .stream()
                .map(bookingMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookingDTO> findBookingsByFlightId(Long flightId) {
        return bookingRepository.findByFlightId(flightId)
                .stream()
                .map(bookingMapper::toDto)
                .collect(Collectors.toList());
    }
}
