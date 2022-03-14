package com.mot.onlineshop.payment.infrastructure.rest.mappers;

import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayURequestRefund;
import com.mot.onlineshop.payment.infrastructure.rest.transform.PaymentTransform;
import org.springframework.stereotype.Component;

@Component
public class RefundPaymentRequestMapper {

    private PaymentTransform paymentTransform = PaymentTransform.builder().build();
    public String map(PayURequestRefund value) {
        return paymentTransform.transformPaymentObjectToString(value);
    }
    public PayURequestRefund map(String value){
        return (PayURequestRefund) paymentTransform.transformPaymentStringToObject(value, new PayURequestRefund());
    }
}
