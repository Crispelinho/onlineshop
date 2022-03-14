package com.mot.onlineshop.payment.infrastructure.rest.mappers;

import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayURequest;
import com.mot.onlineshop.payment.infrastructure.rest.transform.PaymentTransform;
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
