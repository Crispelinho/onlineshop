package com.mot.onlineshop.payment.infrastructure.rest.DTO;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.infrastructure.persistence.entities.PaymentEntity;
import com.mot.onlineshop.payment.infrastructure.rest.Transfoms.RequestPayU;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentRequestDTO {
    private String paymentReference;
    private String paymentMethod;
    private Double paymentValue;
    private RequestPayU payload;
    private String orderReference;

    public PaymentEntity createEntity(PaymentRequestDTO paymentRequestDTO){
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setPaymentReference(paymentRequestDTO.getPaymentReference());
        paymentEntity.setPaymentMethod(Payment.PaymentMethod.valueOf(paymentRequestDTO.getPaymentMethod()));
        paymentEntity.setPaymentValue(paymentRequestDTO.getPaymentValue());
        paymentEntity.setPayload("this.paymentTransform.transformPayload(paymentDTO.getPayload())");
        paymentEntity.setOrderReference(paymentRequestDTO.getOrderReference());
        return paymentEntity;
    }
}
