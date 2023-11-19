package com.mycompany.propertymanagement.service.impl;


import com.mycompany.propertymanagement.convertor.PropertyConvertor;
import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConvertor propertyConvertor;

    @Override
    public PropertyDTO save(PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity = propertyConvertor.propertyDTOToEntity(propertyDTO);
        propertyEntity = propertyRepository.save(propertyEntity);
        propertyDTO = propertyConvertor.propertyEntityToDTO(propertyEntity);
        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAll() {

        List<PropertyEntity> propertyEntityList = (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDTO> listProperties = new ArrayList<>();

        for (PropertyEntity pe : propertyEntityList) {
            PropertyDTO dto = propertyConvertor.propertyEntityToDTO(pe);
            listProperties.add(dto);
        }

        return listProperties;
    }

    @Override
        public PropertyDTO updateProperties(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optionalProperty = propertyRepository.findById(propertyId);
        PropertyDTO propertyDTOUpdated = new PropertyDTO();
        if(optionalProperty.isPresent()) {
            PropertyEntity propertyEntity = optionalProperty.get();
            propertyEntity.setTitle(propertyDTO.getTitle());
            propertyEntity.setDescription(propertyDTO.getDescription());
            propertyEntity.setAddress(propertyDTO.getAddress());
            propertyEntity.setOwnerEmail(propertyDTO.getOwnerEmail());
            propertyEntity.setOwnerName(propertyDTO.getOwnerName());
            propertyEntity.setPrice(propertyDTO.getPrice());
            propertyDTOUpdated = propertyConvertor.propertyEntityToDTO(propertyEntity);
            propertyRepository.save(propertyEntity);
        }
        return propertyDTOUpdated;
    }

    @Override
    public PropertyDTO updatePropertiesDescription(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optionalProperty = propertyRepository.findById(propertyId);
        PropertyDTO propertyDTOUpdated = new PropertyDTO();
        if(optionalProperty.isPresent()) {
            PropertyEntity propertyEntity = optionalProperty.get();
            propertyEntity.setDescription(propertyDTO.getDescription());
            propertyEntity =propertyRepository.save(propertyEntity);
            propertyDTOUpdated = propertyConvertor.propertyEntityToDTO(propertyEntity);
        }
        return propertyDTOUpdated;
    }

    @Override
    public PropertyDTO updatePropertiesPrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optionalProperty = propertyRepository.findById(propertyId);
        PropertyDTO propertyDTOUpdated = new PropertyDTO();
        if(optionalProperty.isPresent()) {
            PropertyEntity propertyEntity = optionalProperty.get();
            propertyEntity.setPrice(propertyDTO.getPrice());
            propertyEntity = propertyRepository.save(propertyEntity);
            propertyDTOUpdated = propertyConvertor.propertyEntityToDTO(propertyEntity);
        }
        return propertyDTOUpdated;
    }

    @Override
    public void deletePropertyById(Long Id) {
        propertyRepository.deleteById(Id);
    }
}
