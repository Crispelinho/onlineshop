package com.mot.onlineshop.payment.domain.models.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class EventId {
    private BigInteger id;

    public static EventId valueOf(String id) {
        return new EventId(new BigInteger(id));
    }

    public static EventId valueOf(BigInteger id) {
        return new EventId(id);
    }
}
