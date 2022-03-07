package com.mot.onlineshop.payment.infrastructure.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

import static com.mot.onlineshop.payment.infrastructure.exceptions.ConstantsExceptions.*;

@Data @EqualsAndHashCode
public class RequestException extends RuntimeException{
    private String code;
    public RequestException(String message,String code){
        super(message);
        //super(ConstantsExceptions.builder().code(code).build().getMessage());
        this.code = code;
    }

}
