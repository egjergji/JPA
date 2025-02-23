package com.crud.service;

import com.crud.model.dto.UserDTO;
import java.util.List;

public interface UserService {

    List<UserDTO> loadAllUsers();

    void saveUser(UserDTO user);

    UserDTO getUserById(Long id);

    UserDTO findByUsername(String username);
}
