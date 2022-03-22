package com.mot.onlineshop.payment.infrastructure.mappers;

import com.mot.onlineshop.payment.infrastructure.transform.PaymentTransform;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayURequestRefund;
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
