package com.mot.onlineshop.payment.infrastructure.rest.mappers;

import com.mot.onlineshop.payment.domain.models.PaymentId;
import com.mot.onlineshop.payment.infrastructure.rest.transform.PaymentTransform;
import org.springframework.stereotype.Component;

@Component
public class PaymentReferenceMapper {

    private PaymentTransform paymentTransform = PaymentTransform.builder().build();

    public PaymentId map(String value) {
        return paymentTransform.transformPaymentReference(value);
    }
    public String map(PaymentId value) { return value.toString();}
}
