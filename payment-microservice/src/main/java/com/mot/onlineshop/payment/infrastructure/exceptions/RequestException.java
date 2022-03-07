package com.mot.onlineshop.payment.infrastructure.exceptions;

import com.mot.onlineshop.payment.infrastructure.exceptions.constants.ExceptionsConstants;
import lombok.Data;

@Data
public class RequestException extends RuntimeException{
    private String code;
    public RequestException(String code){
        super(ExceptionsConstants.builder().message(code).build().getMessage());
        this.code = code;
    }

}
