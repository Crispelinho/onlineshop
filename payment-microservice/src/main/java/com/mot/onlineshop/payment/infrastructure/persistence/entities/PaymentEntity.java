package com.mot.onlineshop.payment.infrastructure.persistence.entities;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.domain.models.PaymentId;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class PaymentEntity {
    @Id
    private BigInteger id;
    private String paymentReference;
    private PaymentMethod paymentMethod;
    public enum PaymentMethod {
        TC, TD, PSE
    }
    private Double paymentValue;
    private LocalDateTime datetimePayment;
    private String payload;
    private UUID orderReference;

    public Payment toPayment() {
        Payment payment = new Payment();
        BeanUtils.copyProperties(this, payment);
        return payment;
    }
}
