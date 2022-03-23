package com.mot.onlineshop.payment.infrastructure.adapters.models.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
public class Payload implements Serializable {
    private String transactionId;
    private String orderId;
    private String status;
    private String provider;
}
