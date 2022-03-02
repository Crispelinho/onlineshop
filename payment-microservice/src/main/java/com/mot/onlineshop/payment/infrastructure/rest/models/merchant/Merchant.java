package com.mot.onlineshop.payment.infrastructure.rest.models.merchant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Merchant {
    private String apiKey;
    private String apiLogin;
}
