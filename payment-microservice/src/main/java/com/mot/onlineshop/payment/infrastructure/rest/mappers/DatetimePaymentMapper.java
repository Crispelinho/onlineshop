package com.mot.onlineshop.payment.infrastructure.rest.mappers;

import com.mot.onlineshop.payment.infrastructure.rest.controllers.PaymentController;
import com.mot.onlineshop.payment.infrastructure.rest.transform.PaymentTransform;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DatetimePaymentMapper {

    private PaymentTransform paymentTransform = PaymentTransform.builder().build();
    private static final Logger log = LogManager.getLogger(PaymentTransform.class);

    public LocalDateTime map(String value) {
        return paymentTransform.transformDateTime(value);
    }
    public String map(LocalDateTime value){
        String methodSignature = "Inicializando método String map(LocalDateTime value)";
        log.info(methodSignature);
        log.info(value.toString());
        return value.toString();
    }

}
