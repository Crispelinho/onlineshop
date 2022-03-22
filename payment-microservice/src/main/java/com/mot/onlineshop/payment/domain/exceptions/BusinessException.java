package com.mot.onlineshop.payment.domain.exceptions;

import com.mot.onlineshop.payment.domain.exceptions.constants.ExceptionsConstants;
import lombok.Data;

import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data @EqualsAndHashCode(callSuper = false)
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