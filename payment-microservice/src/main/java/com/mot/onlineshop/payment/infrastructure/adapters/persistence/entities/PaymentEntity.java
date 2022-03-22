package com.mot.onlineshop.payment.infrastructure.persistence.entities;

import com.mot.onlineshop.payment.domain.models.payment.Payment;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;


@Data
@Entity
@NoArgsConstructor
public class PaymentEntity{
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private BigInteger id;
    private String paymentReference;
    private Payment.PaymentMethod paymentMethod;
    private Double paymentValue;
    private String paymentCountry;
    private LocalDateTime datetimePayment;

    private String payload;
    private String description;
    private String status;
    //private String requestMessage;
    //private String responseMessage;
    private String orderReference;
/*
    public Payment toPayment() {
        Payment payment = new Payment();
        BeanUtils.copyProperties(this, payment);
        return payment;
    }*/
}
