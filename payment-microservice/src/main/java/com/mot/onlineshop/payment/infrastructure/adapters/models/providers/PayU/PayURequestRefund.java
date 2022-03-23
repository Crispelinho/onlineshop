package com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU;

import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.merchant.Merchant;
import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.transaction.TransactionRefund;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
public class PayURequestRefund extends PayURequest {
    private TransactionRefund transaction;
}
