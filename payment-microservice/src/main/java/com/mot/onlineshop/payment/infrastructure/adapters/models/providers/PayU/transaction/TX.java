package com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class TX {
    private Integer value;
    private String currency;
}
