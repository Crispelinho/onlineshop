package com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.transactionresponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class AdditionalInfo {
    private String paymentNetwork;
    private String transactionType;
    private String rejectionType;
}
