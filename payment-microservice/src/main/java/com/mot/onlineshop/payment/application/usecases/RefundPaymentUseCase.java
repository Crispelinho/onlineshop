package com.mot.onlineshop.payment.application.usecases;

import com.mot.onlineshop.payment.domain.exceptions.BusinessException;
import com.mot.onlineshop.payment.domain.exceptions.InvalidPaymentException;
import com.mot.onlineshop.payment.domain.exceptions.PaymentNotFoundException;
import com.mot.onlineshop.payment.domain.models.event.Event;
import com.mot.onlineshop.payment.domain.models.event.EventId;
import com.mot.onlineshop.payment.domain.models.payment.Payment;
import com.mot.onlineshop.payment.domain.ports.clients.PaymentProvider;
import com.mot.onlineshop.payment.domain.ports.persistence.PaymentPersistence;
import com.mot.onlineshop.payment.domain.shared.domaineventbus.DomainEventBus;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
@AllArgsConstructor
public class RefundPaymentUseCase {
    private PaymentProvider paymentProvider;
    private PaymentPersistence paymentPersistence;
    private DomainEventBus domainEventBus;
    private static Logger log = LogManager.getLogger(RefundPaymentUseCase.class);

    public Payment handle(EventId id, Payment payment) throws Exception {
        String methodSignature = "Initialization method handle in RefundPaymentUseCase";
        log.info(methodSignature);

        Payment paymentRegister = paymentPersistence.findByPaymentReference(payment.getPaymentReference());
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("UTC")).minusHours(5L);
        Event event = Event.refund(id, localDateTime);
        if(paymentRegister.getStatus().equals(Payment.Status.DECLINED)){
            event.cancel();
            domainEventBus.publish(event.getDomainEvents());
            throw new BusinessException("B-306", payment.getPaymentReference().getId().toString(), HttpStatus.BAD_REQUEST);
        }
        paymentRegister.setDescription(payment.getDescription());
        Payment paymentResponse = paymentProvider.refundPayment(paymentRegister);
        event.setPayment(paymentResponse);
        log.debug(event);
        domainEventBus.publish(event.getDomainEvents());
        return paymentResponse;
    }
}
