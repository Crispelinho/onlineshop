package com.mot.onlineshop.payment.infrastructure.exceptions;

import lombok.Data;

import static com.mot.onlineshop.payment.infrastructure.exceptions.ConstantsExceptions.*;

import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data @EqualsAndHashCode
public class BusinessException extends RuntimeException{
    private String code;
    private HttpStatus status;
    public BusinessException(String code, HttpStatus status, String message){
        super(ConstantsExceptions.builder().code(code).build().getMessage());
        this.code = code;
        this.status = status;
    }

}