package com.mot.onlineshop.payment.application.usecases;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.domain.models.PaymentId;
import com.mot.onlineshop.payment.domain.ports.clients.PaymentProvider;
import com.mot.onlineshop.payment.domain.ports.persistence.PaymentPersistence;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreatePaymentUseCase {
    private PaymentPersistence paymentPersistence;
    private PaymentProvider paymentProvider;
    //private DomainEventBus domainEventBus;
    private static Logger log = LogManager.getLogger(CreatePaymentUseCase.class);

    public void handle(PaymentId id, Payment payment) throws Exception {
        String methodSignature = "Inicializando método handle";
        log.info(methodSignature);
        paymentPersistence.persist(paymentProvider.getPaymentProvider(payment));
        //domainEventBus.publish(event.getDomainEvents());
    }
}
