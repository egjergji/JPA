package com.crud.mapper;

import com.crud.model.dto.FlightDTO;
import com.crud.model.entity.Flight;

public class FlightMapper extends AbstractMapper<Flight, FlightDTO> {

    @Override
    public Flight toEntity(FlightDTO flightDTO) {
        if (flightDTO == null) {
            return null;
        }
        Flight flight = new Flight();
        flight.setId(flightDTO.getId());
        flight.setOrigin(flightDTO.getOrigin());
        flight.setDestination(flightDTO.getDestination());
        flight.setAirline(flightDTO.getAirline());
        flight.setFlightNumber(flightDTO.getFlightNumber());
        flight.setDepartureDate(flightDTO.getDepartureDate());
        flight.setArrivalDate(flightDTO.getArrivalDate());
        flight.setStatus(flightDTO.getStatus());
        return flight;
    }

    @Override
    public FlightDTO toDto(Flight flight) {
        if (flight == null) {
            return null;
        }
        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setId(flight.getId());
        flightDTO.setOrigin(flight.getOrigin());
        flightDTO.setDestination(flight.getDestination());
        flightDTO.setAirline(flight.getAirline());
        flightDTO.setFlightNumber(flight.getFlightNumber());
        flightDTO.setDepartureDate(flight.getDepartureDate());
        flightDTO.setArrivalDate(flight.getArrivalDate());
        flightDTO.setStatus(flight.getStatus());
        return flightDTO;
    }
}
