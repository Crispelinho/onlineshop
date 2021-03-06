package com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU;

import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.transactionresponse.TransactionResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
public class PayUResponse implements PaymentResponse, Serializable {
    private String code;
    private String error;
    private TransactionResponse transactionResponse;

}
