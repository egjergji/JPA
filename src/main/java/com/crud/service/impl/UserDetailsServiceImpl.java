package com.crud.service.impl;

import com.crud.mapper.UserDetailsMapper;
import com.crud.model.dto.UserDetailsDTO;
import com.crud.model.entity.UserDetails;
import com.crud.repository.UserDetailsRepository;
import com.crud.repository.impl.UserDetailsRepositoryImpl;
import com.crud.service.UserDetailsService;
import java.util.List;
import java.util.stream.Collectors;

public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;
    private final UserDetailsMapper userDetailsMapper;

    public UserDetailsServiceImpl() {
        this.userDetailsRepository = new UserDetailsRepositoryImpl();
        this.userDetailsMapper = new UserDetailsMapper();
    }

    @Override
    public List<UserDetailsDTO> loadAllUserDetails() {
        return userDetailsRepository.findAll()
                .stream()
                .map(userDetailsMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void saveUserDetails(UserDetailsDTO userDetailsDTO) {
        UserDetails userDetails = userDetailsMapper.toEntity(userDetailsDTO);
        userDetailsRepository.save(userDetails);
    }

    @Override
    public UserDetailsDTO getUserDetailsById(Long id) {
        return userDetailsRepository.findById(id)
                .map(userDetailsMapper::toDto)
                .orElse(null);
    }

    @Override
    public UserDetailsDTO findByEmail(String email) {
        return userDetailsRepository.findByEmail(email)
                .map(userDetailsMapper::toDto)
                .orElse(null);
    }

    @Override
    public UserDetailsDTO findByPhoneNumber(String phoneNumber) {
        return userDetailsRepository.findByPhoneNumber(phoneNumber)
                .map(userDetailsMapper::toDto)
                .orElse(null);
    }
}
