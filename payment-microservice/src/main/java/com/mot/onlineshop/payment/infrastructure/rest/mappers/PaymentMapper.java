package com.mot.onlineshop.payment.infrastructure.rest.mappers;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.domain.models.PaymentId;
import com.mot.onlineshop.payment.infrastructure.persistence.entities.PaymentEntity;
import com.mot.onlineshop.payment.infrastructure.rest.DTO.PaymentDTO;
import com.mot.onlineshop.payment.infrastructure.rest.models.PayUResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class PaymentMapper {
    private Payment payment;

    public PaymentId transformPaymentReference(String paymentReference){
        UUID paymentIdUuid = UUID.fromString(paymentReference);
        this.payment.getPaymentReference().setId(paymentIdUuid);
        return this.payment.getPaymentReference();
    }

    public Payment.PaymentMethod transformPaymentMethod(String paymentMethod){
        try {
            return Payment.PaymentMethod.valueOf(paymentMethod);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public PayUResponse transformPayload(String payload){
        return null;
    }

    public PaymentEntity convertToEntity(){
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setPaymentReference(payment.getPaymentReference().toString());
        paymentEntity.setPaymentValue(payment.getPaymentValue());
        paymentEntity.setPaymentMethod(payment.getPaymentMethod());
        paymentEntity.setDatetimePayment(payment.getDatetimePayment());
        paymentEntity.setOrderReference(payment.getOrderReference());

        return paymentEntity;
    }

    public Payment convertToModel(PaymentDTO paymentDTO){
        return this.payment = new Payment(
                paymentDTO.getPaymentMethod(),
                paymentDTO.getPaymentValue(),
                null,
                paymentDTO.getOrderReference());
    }

}
