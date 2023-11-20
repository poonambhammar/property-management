package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.convertor.UserConvertor;
import com.mycompany.propertymanagement.dto.UserDTO;
import com.mycompany.propertymanagement.entity.UserEntity;
import com.mycompany.propertymanagement.exception.BusinessException;
import com.mycompany.propertymanagement.exception.ErrorModel;
import com.mycompany.propertymanagement.repository.UserRepository;
import com.mycompany.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserConvertor userConvertor;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {

        Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
        if(optionalUserEntity.isPresent()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("User Exists");
            errorModel.setMessage("User email already exists");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);

        }else {
            UserEntity userEntity = userConvertor.convertDTOToEntity(userDTO);
            userEntity = userRepository.save(userEntity);
            userDTO = userConvertor.convertEntityToDTO(userEntity);
        }
        return userDTO;

    }

    @Override
    public UserDTO login(String email, String password) {
        UserDTO userDTO = null;
        Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmailAndPassword(email, password);
        if(optionalUserEntity.isPresent()) {
           userDTO = userConvertor.convertEntityToDTO(optionalUserEntity.get());
        }else {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("Invalid Login");
            errorModel.setMessage("Invalid username or password");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
        return userDTO;
    }
}
