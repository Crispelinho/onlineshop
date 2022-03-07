package com.mot.onlineshop.payment.infrastructure.exceptions;

import lombok.Data;

import static com.mot.onlineshop.payment.infrastructure.exceptions.ConstantsExceptions.*;

@Data
public class RequestException extends RuntimeException{
    private String code;
    public RequestException(String code){
        super(ConstantsExceptions.builder().code(code).build().getMessage());
        this.code = code;
    }

}
