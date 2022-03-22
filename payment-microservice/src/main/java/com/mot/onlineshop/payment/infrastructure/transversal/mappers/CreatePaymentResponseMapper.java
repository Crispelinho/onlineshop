package com.mot.onlineshop.payment.infrastructure.transversal.mappers;

import com.mot.onlineshop.payment.infrastructure.transversal.transform.PaymentTransform;
import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.PayUResponse;
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
