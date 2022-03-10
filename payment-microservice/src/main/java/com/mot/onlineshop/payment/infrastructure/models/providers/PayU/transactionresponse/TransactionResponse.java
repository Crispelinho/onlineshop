package com.mot.onlineshop.payment.infrastructure.models.providers.PayU.transactionresponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class TransactionResponse {
    private String orderId;
    private String transactionId;
    private String state;
    private String paymentNetworkResponseCode;
    private String paymentNetworkResponseErrorMessage;
    // private String trazabilityCode;
    // private String authorizationCode;
    // private String pendingReason;
    // private String responseCode;
    // private String errorCode;
    // private String responseMessage;
    // private String transactionDate;
    // private String transactionTime;
    // private String operationDate;
    // private String referenceQuestionnaire;

}
