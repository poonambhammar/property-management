package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {
    @GetMapping("add")
    public Double add(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2){
        return num1+num2;
    }

    @GetMapping("/substract/{num1}/{num2}")
    public Double substract(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2){
        Double result;
        if(num1>num2){
            result = num1-num2;
        }else{
            result =  num2-num1;
        }
        return result;
    }
    @PostMapping("/mul")
    public ResponseEntity<Double> multiply(@RequestBody CalculatorDTO calculatorDTO){
        Double res = calculatorDTO.getNum1()* calculatorDTO.getNum2()*calculatorDTO.getNum3();
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(res, HttpStatus.CREATED);
        return responseEntity;
    }

}
