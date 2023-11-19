package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    @Value("${pms.dummy}")
    private String accessLocalProp;

    @Autowired
    PropertyService propertyService;

    @GetMapping("/sayhello")
    public String sayHello() {
        System.out.println(accessLocalProp);
        return "Say Hello";
    }

    @PostMapping("/save")
    public ResponseEntity<PropertyDTO> save(@RequestBody PropertyDTO propertyDTO) {
        propertyDTO = propertyService.save(propertyDTO);
        ResponseEntity<PropertyDTO> propertyDTOResponseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return propertyDTOResponseEntity;
    }

    @GetMapping("/properties")
    public ResponseEntity<PropertyDTO> getAllProperties() {
        List<PropertyDTO> propertyDTOS = propertyService.getAll();
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity(propertyDTOS, HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("/property/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
        propertyDTO = propertyService.updateProperties(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);

        return responseEntity;

    }

    @PatchMapping("/property/update-desc/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
        propertyDTO = propertyService.updatePropertiesDescription(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);

        return responseEntity;

    }

    @PutMapping("/property/update-price/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
        propertyDTO = propertyService.updatePropertiesPrice(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;

    }
    @DeleteMapping("/property/{Id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long Id){
        propertyService.deletePropertyById(Id);
         ResponseEntity<Void> responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return responseEntity;
    }

}
