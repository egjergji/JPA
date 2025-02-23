package com.crud.repository.impl;

import com.crud.configuration.EntityManagerConfiguration;
import com.crud.model.entity.Booking;
import com.crud.repository.BookingRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class BookingRepositoryImpl implements BookingRepository {

    private final EntityManager entityManager;

    public BookingRepositoryImpl() {
        this.entityManager = EntityManagerConfiguration.getEntityManager();
    }

    @Override
    public Optional<Booking> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Booking.class, id));
    }

    @Override
    public List<Booking> findAll() {
        TypedQuery<Booking> query = entityManager.createQuery("SELECT b FROM Booking b", Booking.class);
        return query.getResultList();
    }

    @Override
    public void save(Booking booking) {
        entityManager.getTransaction().begin();
        if (booking.getId() != null) {
            entityManager.merge(booking);
        } else {
            entityManager.persist(booking);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Booking booking) {
        entityManager.getTransaction().begin();
        Booking managedBooking = entityManager.find(Booking.class, booking.getId());
        if (managedBooking != null) {
            entityManager.remove(managedBooking);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Booking> findByUserId(Long userId) {
        TypedQuery<Booking> query = entityManager.createQuery(
                "SELECT b FROM Booking b WHERE b.user.id = :userId", Booking.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public List<Booking> findByFlightId(Long flightId) {
        TypedQuery<Booking> query = entityManager.createQuery(
                "SELECT b FROM Booking b WHERE b.flight.id = :flightId", Booking.class);
        query.setParameter("flightId", flightId);
        return query.getResultList();
    }
}
