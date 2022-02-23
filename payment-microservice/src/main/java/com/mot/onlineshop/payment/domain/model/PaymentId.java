package com.mot.onlineshop.payment.domain.model;

import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @EqualsAndHashCode
public class PaymentId {

    private UUID id;

    protected PaymentId(UUID id){
        this.id = id;
    }
}
