package com.mot.onlineshop.payment.infrastructure.transversal.exceptions;

import com.mot.onlineshop.payment.domain.exceptions.constants.ExceptionsConstants;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @EqualsAndHashCode(callSuper = false)
public class RequestException extends RuntimeException{
    private String code;
    public RequestException(String code){
        super(ExceptionsConstants.builder().message(code).build().getMessage());
        this.code = code;
    }
}
