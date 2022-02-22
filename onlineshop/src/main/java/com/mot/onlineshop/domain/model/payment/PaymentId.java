package com.mot.onlineshop.domain.model.payment;

import java.util.UUID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Objects;

@Getter @Setter @EqualsAndHashCode
public class PaymentId {

    private UUID id;

    protected PaymentId(UUID id){
        this.id = id;
    }
}
