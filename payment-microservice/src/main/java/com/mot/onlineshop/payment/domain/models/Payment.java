package com.mot.onlineshop.payment.domain.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.ZoneId;


@Data
public class Payment implements Serializable {
    private BigInteger id;
    private PaymentId paymentReference;
    private PaymentMethod paymentMethod;
    public enum PaymentMethod {
        TC, TD, PSE
    }
    private Double paymentValue;
    private LocalDateTime datetimePayment;
    private String requestMessage;
    private String responseMessage;
    private String orderReference;

    public Payment(String paymentMethod, Double paymentValue, String request,String response, String orderReference ){
        this.paymentReference = new PaymentId();
        this.paymentMethod = PaymentMethod.valueOf(paymentMethod);
        this.paymentValue = paymentValue;
        //this.datetimePayment = LocalDateTime.now(ZoneId.of("UTC"));
        this.requestMessage = request;
        this.responseMessage = response;
        this.orderReference = orderReference;
    }
/*
    public Payment(){
        this.paymentReference = new PaymentId();
    }*/
}
