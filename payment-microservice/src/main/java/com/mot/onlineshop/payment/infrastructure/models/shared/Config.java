package com.mot.onlineshop.payment.infrastructure.models.shared;

import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.transaction.AdditionalValues;
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
