package com.mot.onlineshop.payment.application.usecases;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.domain.models.PaymentId;
import com.mot.onlineshop.payment.domain.persistence_ports.PaymentPersistence;
import com.mot.onlineshop.payment.infrastructure.rest.controllers.PaymentController;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreatePaymentUseCase {
    private PaymentPersistence paymentPersistence;
    //private DomainEventBus domainEventBus;
    private static Logger log = LogManager.getLogger(PaymentController.class);

    public void handle(PaymentId id, Payment payment) throws Exception {
        log.info("Entrando a CreatePaymentUseCase");
        paymentPersistence.persist(payment);

        //domainEventBus.publish(event.getDomainEvents());
    }
}
