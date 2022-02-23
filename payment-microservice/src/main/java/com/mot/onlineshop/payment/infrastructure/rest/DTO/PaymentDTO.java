package com.mot.onlineshop.payment.infrastructure.rest.DTO;

import com.mot.onlineshop.payment.domain.model.Payment;
import com.mot.onlineshop.payment.domain.model.PaymentId;
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
    private Request payload;
    private UUID orderReference;

    public PaymentDTO(Payment payment){
        this.paymentReference = payment.getPaymentReference();
        this.paymentMethod = PaymentMethod.valueOf(payment.getPaymentMethod().toString());
        this.paymentValue = payment.getPaymentValue();
        this.payload = new Request(payment.getPayload());
    }
}
