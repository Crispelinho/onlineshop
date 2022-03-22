package com.mot.onlineshop.payment.infrastructure.transversal.eventbus.memory;

import com.mot.onlineshop.payment.domain.interfaces.EventRepository;
import com.mot.onlineshop.payment.domain.models.event.Event;
import com.mot.onlineshop.payment.domain.models.event.EventId;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class InMemoryEventRepository implements EventRepository {

    private AtomicLong sequence;
    private Map<EventId, Event> events;

    public InMemoryEventRepository() {
        this.sequence = new AtomicLong();
        this.events = new HashMap<>();
    }

    @Override
    public EventId getId() {
        Long id = sequence.addAndGet(1);
        return EventId.valueOf(new BigInteger(id.toString()));
    }

    @Override
    public Event findById(EventId id) {
        return events.get(id);
    }

    @Override
    public void persist(Event event) {
        events.put(event.getId(), event);
    }
}
