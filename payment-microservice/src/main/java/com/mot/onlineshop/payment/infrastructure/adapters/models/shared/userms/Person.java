package com.mot.onlineshop.payment.infrastructure.adapters.models.shared.userms;

import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.payer.BillingAddress;
import lombok.Data;

@Data
public class Person {
    private String Id;
    private String merchantPayerId;
    private String firstname;
    private String lastname;
    private String emailAddress;
    private String contactPhone;
    private String dniNumber;
    private BillingAddress billingAddress;
    private String type;
}
