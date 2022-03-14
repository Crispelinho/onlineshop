package com.mot.onlineshop.payment.application.usecases;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.domain.ports.clients.PaymentProvider;
import com.mot.onlineshop.payment.domain.ports.persistence.PaymentPersistence;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RefundPaymentUseCase {
    private PaymentProvider paymentProvider;
    private PaymentPersistence paymentPersistence;
    private static Logger log = LogManager.getLogger(RefundPaymentUseCase.class);

    public Payment handle(Payment payment) {
        String methodSignature = "Inicializando método handle en RefundPaymentUseCase";
        log.info(methodSignature);
        log.info(payment);
        Payment payment1 = paymentPersistence.findByPaymentReference(payment.getPaymentReference());
        log.info(payment1);
        if(payment1 == null) {
            return null;
        }
        payment1.setDescription(payment.getDescription());
        Payment payment2 = paymentProvider.refundPayment(payment1);
        return payment2;
    }
}
