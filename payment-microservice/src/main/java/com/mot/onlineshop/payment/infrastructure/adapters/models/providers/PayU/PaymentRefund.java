package com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU;

import com.mot.onlineshop.payment.domain.models.payment.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class PaymentRefund extends Payment {
    private String refundDescription;
}
