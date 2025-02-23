package com.crud.repository;

import com.crud.model.entity.Flight;
import java.util.List;
import java.util.Optional;

public interface FlightRepository extends Repository<Flight, Long> {

    Optional<Flight> findByFlightNumber(String flightNumber);

    List<Flight> findByOriginAndDestination(String origin, String destination);
}
