package com.mot.onlineshop.payment.infrastructure.bus;


import com.mot.onlineshop.payment.domain.shared.domaineventbus.DomainEvent;
import com.mot.onlineshop.payment.domain.shared.domaineventbus.DomainEventBus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
@Primary
public class InMemoryEventBus implements DomainEventBus {

    private static Logger log = LogManager.getLogger(InMemoryEventBus.class);

    public void publish(DomainEvent event) {
        String methodSignature = "Inicializando método publish en InMemoryEventBus";
        log.debug(methodSignature);
        log.info("Event publish...");
        log.info("%s %s %s%n", event.getClass().getName(), event.getId().getValue(), event.getDate().format(DateTimeFormatter.ISO_DATE_TIME));
    }
}