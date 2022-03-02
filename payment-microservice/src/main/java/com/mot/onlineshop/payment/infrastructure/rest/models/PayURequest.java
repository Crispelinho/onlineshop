package com.mot.onlineshop.payment.infrastructure.rest.models;

import com.mot.onlineshop.payment.infrastructure.rest.models.merchant.Merchant;
import com.mot.onlineshop.payment.infrastructure.rest.models.transacction.Transacction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class PayURequest extends PaymentRequest{
    private String language;
    private String command;
    private Merchant merchant;
    private Transacction transacction;
    private boolean test;
}
