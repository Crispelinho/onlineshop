package com.mot.onlineshop.payment.domain.exceptions;

import lombok.Data;

@Data
public class PaymentNotFoundException extends RuntimeException{
    private String message;
    public PaymentNotFoundException(String message){
        super(message);
        this.message = message;
    }
}
