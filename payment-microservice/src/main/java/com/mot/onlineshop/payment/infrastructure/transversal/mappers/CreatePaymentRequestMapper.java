package com.mot.onlineshop.payment.infrastructure.transversal.mappers;

import com.mot.onlineshop.payment.infrastructure.transversal.transform.PaymentTransform;
import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.PayURequest;
import org.springframework.stereotype.Component;

@Component
public class CreatePaymentRequestMapper {

    private PaymentTransform paymentTransform = PaymentTransform.builder().build();
    public String map(PayURequest value) {
        return paymentTransform.transformPaymentObjectToString(value);
    }
    public PayURequest map(String value){
        return (PayURequest) paymentTransform.transformPaymentStringToObject(value, new PayURequest());
    }

}
