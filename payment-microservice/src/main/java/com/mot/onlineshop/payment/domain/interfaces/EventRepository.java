package com.mot.onlineshop.payment.domain.interfaces;

import com.mot.onlineshop.payment.domain.models.event.Event;
import com.mot.onlineshop.payment.domain.models.event.EventId;

public interface EventRepository {
    EventId getId();

    Event findById(EventId id);

    void persist(Event event);
}
