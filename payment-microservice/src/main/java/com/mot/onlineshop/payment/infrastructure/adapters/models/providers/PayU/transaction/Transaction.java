package com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.transaction;

import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.payer.Payer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Transaction {
    private PayUOrder order;
    private Payer payer;
    private CreditCard creditCard;
    private String type;
    private String paymentMethod;
    private String paymentCountry;
}
