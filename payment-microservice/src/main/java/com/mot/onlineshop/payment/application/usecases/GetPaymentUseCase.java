package com.mot.onlineshop.payment.application.usecases;

import com.mot.onlineshop.payment.application.constants.AppPaymentConstants;
import com.mot.onlineshop.payment.domain.models.payment.Payment;
import com.mot.onlineshop.payment.domain.ports.persistence.PaymentPersistence;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetPaymentUseCase {
    private PaymentPersistence paymentPersistence;

    private static Logger log = LogManager.getLogger(GetPaymentUseCase.class);

    public Payment handle(Payment payment) {
        String methodSignature = "Inicializando método handle en GetPaymentUseCase";
        log.debug(methodSignature);
        log.info(AppPaymentConstants.PROCESSING_USE_CASE +"GetPaymentUseCase");
        return paymentPersistence.findByPaymentReference(payment.getPaymentReference());
    }
}
