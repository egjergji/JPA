package com.crud.repository;

import com.crud.model.entity.User;
import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {

    Optional<User> findByUsername(String username);
}
