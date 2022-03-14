package com.mot.onlineshop.payment.infrastructure.models.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Payload {
    private String transacctionId;
    private String orderId;
    private String state;
}
