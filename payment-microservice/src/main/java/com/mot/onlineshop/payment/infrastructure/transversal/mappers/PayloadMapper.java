package com.mot.onlineshop.payment.infrastructure.transversal.mappers;

import com.mot.onlineshop.payment.infrastructure.transversal.transform.PaymentTransform;
import com.mot.onlineshop.payment.infrastructure.adapters.models.shared.Payload;
import org.springframework.stereotype.Component;

@Component
public class PayloadMapper {

    private PaymentTransform paymentTransform = PaymentTransform.builder().build();

    public Payload map(String value){
        return (Payload) paymentTransform.transformPaymentStringToObject(value, new Payload());
    }

    public String map(Payload payload){
        return paymentTransform.transformPaymentObjectToString(payload);
    }

}
