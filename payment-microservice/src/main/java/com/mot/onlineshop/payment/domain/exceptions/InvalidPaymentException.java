package com.mot.onlineshop.payment.domain.exceptions;

import lombok.Data;

@Data
public class InvalidPaymentException extends RuntimeException{
    private String message;
    private String code;
    public InvalidPaymentException(String message){
        super(message);
        this.message = message;
    }
}
