package com.mot.onlineshop.payment.infrastructure.transversal.mappers;

import com.mot.onlineshop.payment.infrastructure.transversal.transform.PaymentTransform;
import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.PayUResponseRefund;
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
