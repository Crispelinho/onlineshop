package com.mot.onlineshop.payment.infrastructure.rest.models.transacction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Order {
    private String accountId;
    private String referenceCode;
    private String description;
    private String language;
    private String signature;
    private String notityUrl;
    private AdditionalValues additionalValues;
    private Buyer buyer;
    private ShippingAddress shippingAddress;
}
