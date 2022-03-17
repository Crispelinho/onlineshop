package com.mot.onlineshop.payment.infrastructure.models.shared;

import lombok.Data;

@Data
public class Config {
    private String apiKey;
    private String apiLogin;
    private String accountId;
    private String language;
    private String notifyUrl;
    private String merchantId;
}
