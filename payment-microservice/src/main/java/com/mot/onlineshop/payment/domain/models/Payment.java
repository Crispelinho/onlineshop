package com.mot.onlineshop.payment.domain.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.ZoneId;


@Data @NoArgsConstructor
public class Payment implements Serializable {
    private BigInteger id;
    private PaymentId paymentReference = new PaymentId();
    private PaymentMethod paymentMethod;
    public enum PaymentMethod {
        TC, TD, PSE
    }
    private Double paymentValue;
    private LocalDateTime datetimePayment;

    private String orderReference;
    private String paymentCountry;
    private String description;
    private String state;

    private String payload;

    private String requestMessage;
    private String responseMessage;
    public Payment(String paymentMethod, Double paymentValue, String paymentCountry,LocalDateTime datetimePayment,String request,String response, String orderReference ){
        this.paymentMethod = PaymentMethod.valueOf(paymentMethod);
        this.paymentValue = paymentValue;
        this.paymentCountry = paymentCountry;
        this.datetimePayment = datetimePayment;
        this.requestMessage = request;
        this.responseMessage = response;
        this.orderReference = orderReference;
    }
/*
    public Payment(){
        this.paymentReference = new PaymentId();
    }*/
}
