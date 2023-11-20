package com.mycompany.propertymanagement.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class BusinessException extends RuntimeException{
    private List<ErrorModel> errorModels;
    public BusinessException(List<ErrorModel> errorModel){
        this.errorModels = errorModel;
    }
}
