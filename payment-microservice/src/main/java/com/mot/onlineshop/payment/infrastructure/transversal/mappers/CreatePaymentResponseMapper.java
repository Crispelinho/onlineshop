package com.mot.onlineshop.payment.infrastructure.mappers;

import com.mot.onlineshop.payment.infrastructure.transform.PaymentTransform;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayUResponse;
import org.springframework.stereotype.Component;

@Component
public class CreatePaymentResponseMapper {
    private PaymentTransform paymentTransform = PaymentTransform.builder().build();

    public PayUResponse map(String value){
        return (PayUResponse) paymentTransform.transformPaymentStringToObject(value, new PayUResponse());
    }
    public String map(PayUResponse value) {
        return paymentTransform.transformPaymentObjectToString(value);
    }
}
