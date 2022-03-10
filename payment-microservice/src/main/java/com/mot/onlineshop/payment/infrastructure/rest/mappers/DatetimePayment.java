package com.mot.onlineshop.payment.infrastructure.rest.mappers;

import com.mot.onlineshop.payment.domain.models.PaymentId;
import com.mot.onlineshop.payment.infrastructure.rest.transform.PaymentTransform;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DatetimePayment {

    private PaymentTransform paymentTransform = PaymentTransform.builder().build();

    public LocalDateTime map(String value) {
        return paymentTransform.transformDateTime(value);
    }
    public String map(LocalDateTime value){
        return value.toString();
    }

}
