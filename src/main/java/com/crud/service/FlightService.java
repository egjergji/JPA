package com.crud.service;

import com.crud.model.dto.FlightDTO;
import java.util.List;

public interface FlightService {

    List<FlightDTO> loadAllFlights();

    void saveFlight(FlightDTO flight);

    FlightDTO getFlightById(Long id);

    FlightDTO findByFlightNumber(String flightNumber);

    List<FlightDTO> findByOriginAndDestination(String origin, String destination);
}
