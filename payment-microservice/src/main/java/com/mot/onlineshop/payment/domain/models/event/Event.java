package com.mot.onlineshop.payment.domain.models.event;

import com.mot.onlineshop.payment.domain.models.payment.Payment;
import com.mot.onlineshop.payment.domain.models.payment.PaymentCreatedDomainEvent;
import com.mot.onlineshop.payment.domain.models.payment.PaymentRefundDomainEvent;
import com.mot.onlineshop.payment.domain.shared.domaineventbus.DomainEventCollection;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
public class Event implements Serializable {

    private EventId id;
    private Status status;
    private LocalDateTime schedule;
    private Payment payment;

    private DomainEventCollection domainEvents;

    public enum Status {
        ACTIVE, CANCELLED, HIDDEN
    }

    public Event(EventId id, LocalDateTime schedule) {
        this.id = id;
        this.status = Status.ACTIVE;
        this.schedule = schedule;
        this.domainEvents = new DomainEventCollection();
    }

    public void setPayment(Payment payment){
        this.payment = payment;
    }

    public static Event create(EventId id, LocalDateTime schedule) throws Exception {

        Event event = new Event(id, schedule);

        event.domainEvents.add(new PaymentCreatedDomainEvent(event.getId()));
        return event;
    }

    public static Event refund(EventId id, LocalDateTime schedule) throws Exception {

        Event event = new Event(id, schedule);

        event.domainEvents.add(new PaymentRefundDomainEvent(event.getId()));
        return event;
    }

    public void activate() {
        this.status = Status.ACTIVE;
        // TODO: domain event
    }

    public void cancel() {
        this.status = Status.CANCELLED;

        domainEvents.add(new PaymentRefundDomainEvent(id));
    }

    public void hide() {
        this.status = Status.HIDDEN;
        // TODO: domain event
    }

}