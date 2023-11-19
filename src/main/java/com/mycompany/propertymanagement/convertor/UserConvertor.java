package com.mycompany.propertymanagement.convertor;

import com.mycompany.propertymanagement.dto.UserDTO;
import com.mycompany.propertymanagement.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConvertor {
    public UserEntity convertDTOToEntity(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setOwnerName(userDTO.getOwnerName());
        userEntity.setOwnerEmail(userDTO.getOwnerEmail());
        userEntity.setPhone(userDTO.getPhone());
        userEntity.setPassword(userDTO.getPassword());
        return userEntity;
    }
    public UserDTO convertEntityToDTO(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userEntity.getUserId());
        userDTO.setOwnerName(userEntity.getOwnerName());
        userDTO.setOwnerEmail(userEntity.getOwnerEmail());
        userDTO.setPhone(userEntity.getPhone());
        return userDTO;
    }
}
