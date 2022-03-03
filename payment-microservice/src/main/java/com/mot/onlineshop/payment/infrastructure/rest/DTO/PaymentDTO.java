package com.mot.onlineshop.payment.infrastructure.rest.DTO;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.infrastructure.rest.mappers.PaymentMapper;
import com.mot.onlineshop.payment.infrastructure.rest.models.PayURequest;
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
    private String orderReference;
    private PayURequest payload;

    private static final PaymentMapper paymentTransform = PaymentMapper.builder()
            .build();

    public PaymentDTO(Payment payment){
        this.paymentReference = payment.getPaymentReference().getId().toString();
        this.paymentMethod = payment.getPaymentMethod().toString();
        this.paymentValue = payment.getPaymentValue();
        this.orderReference = payment.getOrderReference();
        this.payload = (PayURequest) paymentTransform.transformPaymentStringToObject(payment.getRequestMessage(),new PayURequest());
    }
}
