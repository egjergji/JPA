package com.crud.service.impl;

import com.crud.mapper.FlightMapper;
import com.crud.model.dto.FlightDTO;
import com.crud.model.entity.Flight;
import com.crud.repository.FlightRepository;
import com.crud.repository.impl.FlightRepositoryImpl;
import com.crud.service.FlightService;
import java.util.List;
import java.util.stream.Collectors;

public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    public FlightServiceImpl() {
        this.flightRepository = new FlightRepositoryImpl();
        this.flightMapper = new FlightMapper();
    }

    @Override
    public List<FlightDTO> loadAllFlights() {
        return flightRepository.findAll()
                .stream()
                .map(flightMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void saveFlight(FlightDTO flightDTO) {
        Flight flight = flightMapper.toEntity(flightDTO);
        flightRepository.save(flight);
    }

    @Override
    public FlightDTO getFlightById(Long id) {
        return flightRepository.findById(id)
                .map(flightMapper::toDto)
                .orElse(null);
    }

    @Override
    public FlightDTO findByFlightNumber(String flightNumber) {
        return flightRepository.findByFlightNumber(flightNumber)
                .map(flightMapper::toDto)
                .orElse(null);
    }

    @Override
    public List<FlightDTO> findByOriginAndDestination(String origin, String destination) {
        return flightRepository.findByOriginAndDestination(origin, destination)
                .stream()
                .map(flightMapper::toDto)
                .collect(Collectors.toList());
    }
}
