package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.dto.UserDTO;

public interface UserService {
    UserDTO registerUser(UserDTO userDTO);
    UserDTO login(String email, String password);

}
