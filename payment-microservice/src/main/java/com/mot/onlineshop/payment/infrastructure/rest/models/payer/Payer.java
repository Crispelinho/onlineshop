package com.mot.onlineshop.payment.infrastructure.rest.models.payer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Payer {
    private String merchantPayerId;
    private String fullName;
    private String emailAddress;
    private String contactPhone;
    private String dniNumber;
    private BillingAddress billingAddress;
    private String type;
    private String paymentMethod;
    private String paymentCountry;
}