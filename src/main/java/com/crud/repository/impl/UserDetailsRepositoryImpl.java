package com.crud.repository.impl;

import com.crud.configuration.EntityManagerConfiguration;
import com.crud.model.entity.UserDetails;
import com.crud.repository.UserDetailsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class UserDetailsRepositoryImpl implements UserDetailsRepository {

    private final EntityManager entityManager;

    public UserDetailsRepositoryImpl() {
        this.entityManager = EntityManagerConfiguration.getEntityManager();
    }

    @Override
    public Optional<UserDetails> findById(Long id) {
        return Optional.ofNullable(entityManager.find(UserDetails.class, id));
    }

    @Override
    public List<UserDetails> findAll() {
        TypedQuery<UserDetails> query = entityManager.createQuery("SELECT ud FROM UserDetails ud", UserDetails.class);
        return query.getResultList();
    }

    @Override
    public void save(UserDetails userDetails) {
        entityManager.getTransaction().begin();
        if (userDetails.getId() != null) {
            entityManager.merge(userDetails);
        } else {
            entityManager.persist(userDetails);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(UserDetails userDetails) {
        entityManager.getTransaction().begin();
        UserDetails managedUserDetails = entityManager.find(UserDetails.class, userDetails.getId());
        if (managedUserDetails != null) {
            entityManager.remove(managedUserDetails);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public Optional<UserDetails> findByEmail(String email) {
        TypedQuery<UserDetails> query = entityManager.createQuery(
                "SELECT ud FROM UserDetails ud WHERE ud.email = :email", UserDetails.class);
        query.setParameter("email", email);
        return query.getResultStream().findFirst();
    }

    @Override
    public Optional<UserDetails> findByPhoneNumber(String phoneNumber) {
        TypedQuery<UserDetails> query = entityManager.createQuery(
                "SELECT ud FROM UserDetails ud WHERE ud.phoneNumber = :phoneNumber", UserDetails.class);
        query.setParameter("phoneNumber", phoneNumber);
        return query.getResultStream().findFirst();
    }
}
