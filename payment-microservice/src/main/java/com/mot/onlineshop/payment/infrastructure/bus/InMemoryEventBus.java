package com.mot.onlineshop.payment.infrastructure.bus;


import com.mot.onlineshop.payment.domain.shared.domaineventbus.DomainEvent;
import com.mot.onlineshop.payment.domain.shared.domaineventbus.DomainEventBus;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
@Primary
public class InMemoryEventBus implements DomainEventBus {

    public void publish(DomainEvent event) {
        System.out.printf("%s %s %s%n", event.getClass().getName(), event.getId().getValue(), event.getDate().format(DateTimeFormatter.ISO_DATE_TIME));
    }
}