package com.mycompany.propertymanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDTO {
    private  Long Id;
    private  String title;
    private String description;
    private Double price;
    private String address;
    private Long userId;



}
