package com.mot.onlineshop.payment.infrastructure.rest.models;

import com.mot.onlineshop.payment.infrastructure.rest.models.merchant.Merchant;
import com.mot.onlineshop.payment.infrastructure.rest.models.transacction.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
public class PayURequest implements PaymentRequest, Serializable {
    private String language;
    private String command;
    private Merchant merchant;
    private Transaction transaction;
    private boolean test;
}
