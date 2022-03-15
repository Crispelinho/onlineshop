package com.mot.onlineshop.payment.infrastructure.rest.DTO;

import com.mot.onlineshop.payment.domain.models.payment.Payment;
import com.mot.onlineshop.payment.infrastructure.models.shared.Payload;
import com.mot.onlineshop.payment.infrastructure.rest.transform.PaymentTransform;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class PaymentDTO implements Serializable {
    private String paymentReference;
    private String paymentMethod;
    private Double paymentValue;
    private String paymentCountry;
    private String datetimePayment;
    private String orderReference;
    private String description;
    private String status;
    private Payload payload;

    public PaymentDTO(Payment payment){
        PaymentTransform paymentTransform = PaymentTransform.builder()
                .build();
        if(payment.getPaymentReference().getId() != null){
            this.setPaymentReference(payment.getPaymentReference().getId().toString());
        }
        if(payment.getPaymentMethod()!=null){
            this.paymentMethod = payment.getPaymentMethod().toString();
        }
        this.description = payment.getDescription();
        this.paymentValue = payment.getPaymentValue();
        this.paymentCountry = payment.getPaymentCountry();
        this.orderReference = payment.getOrderReference();
        this.payload = (Payload) paymentTransform.transformPaymentStringToObject(payment.getPayload(),new Payload());
     }
}
