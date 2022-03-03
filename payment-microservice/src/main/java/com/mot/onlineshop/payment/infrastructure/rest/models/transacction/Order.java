package com.mot.onlineshop.payment.infrastructure.rest.models.transacction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Order {
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
