package com.mot.onlineshop.payment.domain.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.ZoneId;
import java.util.UUID;

@Data @NoArgsConstructor
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
    private String orderReference;

    public Payment(String paymentMethod, Double paymentValue, String payload, String orderReference ){
        this.paymentReference = new PaymentId(UUID.randomUUID());
        this.paymentMethod = PaymentMethod.valueOf(paymentMethod);
        this.paymentValue = paymentValue;
        this.datetimePayment = LocalDateTime.now(ZoneId.of("UTC"));
        this.payload = payload;
        this.orderReference = orderReference;
    }
}
