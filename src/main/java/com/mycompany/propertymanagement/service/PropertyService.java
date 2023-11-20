package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {
    PropertyDTO save(PropertyDTO propertyDTO);

    List<PropertyDTO> getAll();

    List<PropertyDTO> getPropertyByUserId(Long userId);

    PropertyDTO updateProperties(PropertyDTO propertyDTO, Long propertyId);

    PropertyDTO updatePropertiesDescription(PropertyDTO propertyDTO, Long propertyId);

    PropertyDTO updatePropertiesPrice(PropertyDTO propertyDTO, Long propertyId);

    void deletePropertyById(Long Id);


}
