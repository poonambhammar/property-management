package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.convertor.UserConvertor;
import com.mycompany.propertymanagement.dto.UserDTO;
import com.mycompany.propertymanagement.entity.UserEntity;
import com.mycompany.propertymanagement.repository.UserRepository;
import com.mycompany.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserConvertor userConvertor;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        UserEntity userEntity = userConvertor.convertDTOToEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        userDTO = userConvertor.convertEntityToDTO(userEntity);
        return userDTO;

    }

    @Override
    public UserDTO login(String email, String password) {
        UserEntity userEntity = userRepository.findByownerEmailAndPassword(email, password);
        UserDTO userDTO = userConvertor.convertEntityToDTO(userEntity);
        return userDTO;
    }
}
