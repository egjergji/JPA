package com.crud.service;

import com.crud.model.dto.UserDetailsDTO;
import java.util.List;

public interface UserDetailsService {

    List<UserDetailsDTO> loadAllUserDetails();

    void saveUserDetails(UserDetailsDTO userDetails);

    UserDetailsDTO getUserDetailsById(Long id);

    UserDetailsDTO findByEmail(String email);

    UserDetailsDTO findByPhoneNumber(String phoneNumber);
}
