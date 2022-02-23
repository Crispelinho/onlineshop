package com.mot.onlineshop.payment.domain.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.UUID;

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
    private String payload;
    private UUID orderReference;

    public Payment(String paymentMethod, Double paymentValue, String payload, UUID orderReference ){
        this.paymentReference = new PaymentId(UUID.randomUUID());
        this.paymentMethod = PaymentMethod.valueOf(paymentMethod);
        this.paymentValue = paymentValue;
        this.datetimePayment = LocalDateTime.now();
        this.orderReference = orderReference;
    }
}
