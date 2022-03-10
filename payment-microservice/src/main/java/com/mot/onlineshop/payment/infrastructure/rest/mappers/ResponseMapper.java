package com.mot.onlineshop.payment.infrastructure.rest.mappers;

import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayUResponse;
import com.mot.onlineshop.payment.infrastructure.rest.transform.PaymentTransform;
import org.springframework.stereotype.Component;

@Component
public class ResponseMapper {
    private PaymentTransform paymentTransform = PaymentTransform.builder().build();

    public PayUResponse map(String value){
        return (PayUResponse) paymentTransform.transformPaymentStringToObject(value, new PayUResponse());
    }
    public String map(PayUResponse value) {
        return paymentTransform.transformPaymentObjectToString(value);
    }
}
