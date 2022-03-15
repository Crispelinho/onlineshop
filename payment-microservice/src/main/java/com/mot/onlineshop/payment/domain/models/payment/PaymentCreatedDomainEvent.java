package com.mot.onlineshop.payment.domain.models.payment;

import com.mot.onlineshop.payment.domain.models.event.EventId;
import com.mot.onlineshop.payment.domain.shared.domaineventbus.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class PaymentCreatedDomainEvent extends DomainEvent {
    private EventId eventId;

}
