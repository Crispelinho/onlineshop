package com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.transaction;

import lombok.Data;

@Data
public class TransactionRefund {
    private OrderId order;
    private String type;
    private String reason;
    private String parentTransactionId;
}
