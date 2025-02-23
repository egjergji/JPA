package com.crud.repository;

import com.crud.model.entity.UserDetails;
import java.util.Optional;

public interface UserDetailsRepository extends Repository<UserDetails, Long> {

    Optional<UserDetails> findByEmail(String email);

    Optional<UserDetails> findByPhoneNumber(String phoneNumber);
}
