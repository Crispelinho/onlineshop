package com.mot.onlineshop.payment.infrastructure.rest.mappers;

import com.mot.onlineshop.payment.domain.models.payment.PaymentId;
import com.mot.onlineshop.payment.infrastructure.rest.transform.PaymentTransform;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class PaymentReferenceMapper {

    private PaymentTransform paymentTransform = PaymentTransform.builder().build();
    private static final Logger log = LogManager.getLogger(PaymentReferenceMapper.class);

    public PaymentId map(String value) {
        return paymentTransform.transformPaymentReference(value);
    }
    public String map(PaymentId value) { return value.getId().toString();}
}
