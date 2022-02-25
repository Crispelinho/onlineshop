package com.mot.onlineshop.payment.infrastructure.rest.DTO;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.infrastructure.persistence.entities.PaymentEntity;
import com.mot.onlineshop.payment.infrastructure.rest.Transfoms.PaymentTransform;
import com.mot.onlineshop.payment.infrastructure.rest.Transfoms.RequestPayU;
import lombok.Data;
import lombok.NoArgsConstructor;
//import com.google.gson.Gson;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class PaymentDTO implements Serializable {
    private String paymentReference;
    private String paymentMethod;
    private Double paymentValue;
    private RequestPayU payload;
    private String orderReference;

    private PaymentTransform paymentTransform = PaymentTransform.builder()
            .build();

    public PaymentDTO(Payment payment){
        this.paymentReference = String.valueOf(payment.getPaymentReference());
        this.paymentMethod = payment.getPaymentMethod().toString();
        this.paymentValue = payment.getPaymentValue();
        this.payload = paymentTransform.transformPayload(payment.getPayload());
    }

    public PaymentEntity createEntity(PaymentDTO paymentDTO){
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setPaymentReference(paymentDTO.getPaymentReference());
        paymentEntity.setPaymentMethod(Payment.PaymentMethod.valueOf(paymentDTO.getPaymentMethod()));
        paymentEntity.setPaymentValue(paymentDTO.getPaymentValue());
        paymentEntity.setPayload("this.paymentTransform.transformPayload(paymentDTO.getPayload())");
        paymentEntity.setOrderReference(paymentDTO.getOrderReference());
        return paymentEntity;
    }
}
