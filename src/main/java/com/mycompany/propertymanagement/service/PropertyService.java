package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;

import java.util.List;

public interface PropertyService {
    PropertyDTO save(PropertyDTO propertyDTO);
    List<PropertyDTO> getAll();
    PropertyDTO updateProperties(PropertyDTO propertyDTO, Long propertyId);
    PropertyDTO updatePropertiesDescription(PropertyDTO propertyDTO, Long propertyId);
    PropertyDTO updatePropertiesPrice(PropertyDTO propertyDTO, Long propertyId);

    void deletePropertyById(Long Id);


}
