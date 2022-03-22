package com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Buyer {

    private String merchantBuyerId;
    private String fullName;
    private String emailAddress;
    private String contactPhone;
    private String dniNumber;
    private ShippingAddress shippingAddress;

}
