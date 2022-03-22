package com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.transactionresponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

@Data @NoArgsConstructor @AllArgsConstructor
@Root(name = "transactionResponse",strict = false)
public class TransactionResponse implements Serializable {
    @Element(name="orderId")
    private String orderId;
    @Element(name="transactionId")
    private String transactionId;
    @Element(name="state")
    private String state;
    @Element(name="paymentNetworkResponseCode")
    private String paymentNetworkResponseCode;
    @Element(name="paymentNetworkResponseErrorMessage")
    private String paymentNetworkResponseErrorMessage;
    @Element(name="trazabilityCode")
    private String trazabilityCode;
    @Element(name="authorizationCode")
    private String authorizationCode;
    @Element(name="pendingReason")
    private String pendingReason;
    @Element(name="responseCode")
    private String responseCode;
    @Element(name="errorCode")
    private String errorCode;
    @Element(name="responseMessage")
    private String responseMessage;
    @Element(name="transactionDate")
    private String transactionDate;
    @Element(name="transactionTime")
    private String transactionTime;
    @Element(name="operationDate")
    private String operationDate;
    @Element(name="referenceQuestionnaire")
    private String referenceQuestionnaire;
    //private ExtraParameters extraParameters;
    @Element(name="additionalInfo")
    private AdditionalInfo additionalInfo;
}
