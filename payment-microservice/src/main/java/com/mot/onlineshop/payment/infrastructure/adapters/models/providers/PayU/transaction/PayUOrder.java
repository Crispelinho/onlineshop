package com.mot.onlineshop.payment.infrastructure.models.providers.PayU.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class PayUOrder {
    private String accountId;
    private AdditionalValues additionalValues;
    private Buyer buyer;
    private String description;
    private String language;
    private String notifyUrl;
    private String referenceCode;
    private ShippingAddress shippingAddress;
    private String signature;
}
