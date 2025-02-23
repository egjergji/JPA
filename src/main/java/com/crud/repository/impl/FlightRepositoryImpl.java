package com.crud.repository.impl;

import com.crud.configuration.EntityManagerConfiguration;
import com.crud.model.entity.Flight;
import com.crud.repository.FlightRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class FlightRepositoryImpl implements FlightRepository {

    private final EntityManager entityManager;

    public FlightRepositoryImpl() {
        this.entityManager = EntityManagerConfiguration.getEntityManager();
    }

    @Override
    public Optional<Flight> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Flight.class, id));
    }

    @Override
    public List<Flight> findAll() {
        TypedQuery<Flight> query = entityManager.createQuery("SELECT f FROM Flight f", Flight.class);
        return query.getResultList();
    }

    @Override
    public void save(Flight flight) {
        entityManager.getTransaction().begin();
        if (flight.getId() != null) {
            entityManager.merge(flight);
        } else {
            entityManager.persist(flight);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Flight flight) {
        entityManager.getTransaction().begin();
        Flight managedFlight = entityManager.find(Flight.class, flight.getId());
        if (managedFlight != null) {
            entityManager.remove(managedFlight);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public Optional<Flight> findByFlightNumber(String flightNumber) {
        TypedQuery<Flight> query = entityManager.createQuery(
                "SELECT f FROM Flight f WHERE f.flightNumber = :flightNumber", Flight.class);
        query.setParameter("flightNumber", flightNumber);
        return query.getResultStream().findFirst();
    }

    @Override
    public List<Flight> findByOriginAndDestination(String origin, String destination) {
        TypedQuery<Flight> query = entityManager.createQuery(
                "SELECT f FROM Flight f WHERE f.origin = :origin AND f.destination = :destination", Flight.class);
        query.setParameter("origin", origin);
        query.setParameter("destination", destination);
        return query.getResultList();
    }
}
