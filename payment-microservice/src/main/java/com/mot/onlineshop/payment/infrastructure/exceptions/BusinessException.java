package com.mot.onlineshop.payment.infrastructure.exceptions;

import com.mot.onlineshop.payment.infrastructure.exceptions.constants.ExceptionsConstants;
import lombok.Data;

import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
public class BusinessException extends RuntimeException{
    private String code;
    private HttpStatus status;
    public BusinessException(String code, HttpStatus status){
        super(ExceptionsConstants.builder().message(code).build().getMessage());
        this.code = code;
        this.status = status;
    }

}