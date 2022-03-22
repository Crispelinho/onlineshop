package com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU;

import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.transactionresponse.TransactionResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
@Root(name = "paymentResponse", strict = true)
public class PayUResponseRefund implements PaymentResponse, Serializable {
    @Element(name = "code")
    private String code;
    @Element(name = "error")
    private String error;
    @Element(name="transactionResponse")
    private TransactionResponse transactionResponse;
}
