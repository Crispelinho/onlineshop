package com.mot.onlineshop.payment.domain.exceptions;

import lombok.Data;

import org.springframework.http.HttpStatus;

@Data
public class BusinessException extends RuntimeException{
    private String code;
    private String param;
    private HttpStatus status;
    public BusinessException(String code, String param, HttpStatus status){
        super(ExceptionsConstants.builder().message(code).param(param).build().getMessage());
        this.code = code;
        this.status = status;
    }

}