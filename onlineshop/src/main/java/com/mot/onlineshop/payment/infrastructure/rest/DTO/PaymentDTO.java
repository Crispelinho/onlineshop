package com.mot.onlineshop.infrastructure.rest.DTO;

import com.mot.onlineshop.domain.model.Payment;
import com.mot.onlineshop.domain.model.PaymentId;
import lombok.Data;
import java.util.UUID;

@Data
public class PaymentDTO {
    private PaymentId paymentReference;
    private PaymentMethod paymentMethod;
    public enum PaymentMethod {
        TC, TD, PSE
    }
    private Double paymentValue;
    private String payload;
    private UUID orderReference;

    public PaymentDTO(Payment payment){
        this.paymentReference = payment.getPaymentReference();
        this.paymentMethod = PaymentMethod.valueOf(payment.getPaymentMethod().toString());
        this.paymentValue = payment.getPaymentValue();
        this.payload = payment.getPayload();
    }
}
