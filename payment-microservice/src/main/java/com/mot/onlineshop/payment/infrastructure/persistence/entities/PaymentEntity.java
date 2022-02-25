package com.mot.onlineshop.payment.infrastructure.persistence.entities;

import com.mot.onlineshop.payment.domain.models.Payment;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

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
    private LocalDateTime datetimePayment;
    private String payload;
    private String orderReference;

    public Payment toPayment() {
        Payment payment = new Payment();
        BeanUtils.copyProperties(this, payment);
        return payment;
    }
}
