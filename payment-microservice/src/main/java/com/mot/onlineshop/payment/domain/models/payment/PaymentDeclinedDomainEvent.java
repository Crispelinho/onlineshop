package com.mot.onlineshop.payment.domain.models.payment;

import com.mot.onlineshop.payment.domain.models.event.EventId;
import com.mot.onlineshop.payment.domain.shared.domaineventbus.DomainEvent;

public class PaymentDeclinedDomainEvent extends DomainEvent {
    private EventId eventId;
}
