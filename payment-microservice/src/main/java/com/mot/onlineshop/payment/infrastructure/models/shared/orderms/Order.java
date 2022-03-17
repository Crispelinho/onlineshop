package com.mot.onlineshop.payment.infrastructure.models.shared.orderms;

import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.transaction.Buyer;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.transaction.ShippingAddress;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.transaction.AdditionalValues;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Order {
    private UUID orderReference;
    private String state;
    private Double amount;
    private LocalDateTime dateTime;
    private AdditionalValues additionalValues;
    private String dniNumber;
    private Buyer buyer;
    private String description;
    private ShippingAddress shippingAddress;
}
