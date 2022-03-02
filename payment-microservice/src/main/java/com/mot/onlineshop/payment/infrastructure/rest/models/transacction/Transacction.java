package com.mot.onlineshop.payment.infrastructure.rest.models.transacction;

import com.mot.onlineshop.payment.infrastructure.rest.models.payer.Payer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Transacction {
    private Order order;
    private Payer payer;
    private CreditCard creditCard;
    private String type;
    private String paymentMethod;
    private String paymentCountry;
}
