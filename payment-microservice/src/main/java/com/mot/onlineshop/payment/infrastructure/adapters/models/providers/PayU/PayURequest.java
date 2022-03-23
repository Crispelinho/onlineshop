package com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU;

import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.merchant.Merchant;
import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.transaction.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
public class PayURequest implements PaymentRequest, Serializable {
    private String language;
    private String command;
    private Merchant merchant;
    private boolean test;
}
