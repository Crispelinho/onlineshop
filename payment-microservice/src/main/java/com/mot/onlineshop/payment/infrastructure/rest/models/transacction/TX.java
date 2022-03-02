package com.mot.onlineshop.payment.infrastructure.rest.models.transacction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class TX {
    private Integer value;
    private String currency;
}
