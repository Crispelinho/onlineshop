package com.mot.onlineshop.payment.infrastructure.transversal.mappers;

import com.mot.onlineshop.payment.infrastructure.transversal.transform.PaymentTransform;
import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.PayURequestRefund;
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
