package com.api.library.service;

import com.api.library.dto.UserDTO;
import com.api.library.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MappingService {

    @Autowired
    private ModelMapper modelMapper;

    public User toModel(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    public UserDTO toDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

}
