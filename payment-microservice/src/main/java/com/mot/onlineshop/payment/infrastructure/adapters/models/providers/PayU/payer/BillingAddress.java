package com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.payer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class BillingAddress {
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String phone;
}
