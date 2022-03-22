package com.mot.onlineshop.payment.infrastructure.mappers;

import com.mot.onlineshop.payment.infrastructure.transform.PaymentTransform;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayUResponseRefund;
import org.springframework.stereotype.Component;

@Component
public class RefundPaymentResponseMapper {

    private PaymentTransform paymentTransform = PaymentTransform.builder().build();
    public PayUResponseRefund map(String value){
        return (PayUResponseRefund) paymentTransform.transformPaymentStringToObject(value, new PayUResponseRefund());
    }
    public String map(PayUResponseRefund value) {
        return paymentTransform.transformPaymentObjectToString(value);
    }
}
