package com.crud.repository;

import com.crud.model.entity.Booking;
import java.util.List;

public interface BookingRepository extends Repository<Booking, Long> {

    List<Booking> findByUserId(Long userId);

    List<Booking> findByFlightId(Long flightId);
}
