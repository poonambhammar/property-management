package com.mycompany.propertymanagement.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserDTO {
    private Long userId;
    private String ownerName;
    @NotNull(message = "Owner email is mandatory")
    @Size(min = 5, max = 20, message = "email should be between 5 to 50")
    private String ownerEmail;

    private String phone;
    @NotNull(message = "Password cannot be null")
    @NotEmpty(message = "Cannot be empty")
    private String password;
}
