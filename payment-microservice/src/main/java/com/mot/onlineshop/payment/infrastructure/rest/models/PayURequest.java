package com.mot.onlineshop.payment.infrastructure.rest.models;

import com.mot.onlineshop.payment.infrastructure.rest.models.merchant.Merchant;
import com.mot.onlineshop.payment.infrastructure.rest.models.transacction.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class PayURequest implements PaymentRequest{
    private String language;
    private String command;
    private Merchant merchant;
    private Transaction transaction;
    private boolean test;
}
