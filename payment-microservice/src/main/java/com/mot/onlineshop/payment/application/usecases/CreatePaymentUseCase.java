package com.mot.onlineshop.payment.application.usecases;

import com.mot.onlineshop.payment.domain.models.event.Event;
import com.mot.onlineshop.payment.domain.models.event.EventId;
import com.mot.onlineshop.payment.domain.models.payment.Payment;
import com.mot.onlineshop.payment.domain.models.payment.PaymentId;
import com.mot.onlineshop.payment.domain.ports.clients.PaymentProvider;
import com.mot.onlineshop.payment.domain.ports.persistence.PaymentPersistence;
import com.mot.onlineshop.payment.domain.shared.domaineventbus.DomainEventBus;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
@AllArgsConstructor
public class CreatePaymentUseCase {
    private PaymentPersistence paymentPersistence;
    private PaymentProvider paymentProvider;
    private DomainEventBus domainEventBus;
    private static Logger log = LogManager.getLogger(CreatePaymentUseCase.class);

    public Payment handle(EventId id, Payment payment) throws Exception {
        String methodSignature = "Inicializando método handle en CreatePaymentUseCase";
        log.info(methodSignature);
        Payment paymentRegister = paymentPersistence.persist(paymentProvider.postPaymentProvider(payment));
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("UTC")).minusHours(5L);
        Event event = Event.create(id, localDateTime);
        event.setPayment(paymentRegister);
        domainEventBus.publish(event.getDomainEvents());
        return paymentRegister;
    }
}
