package com.mot.onlineshop.payment.infrastructure.ports.rest.api.DTOs;

import com.mot.onlineshop.payment.domain.models.payment.Payment;
import com.mot.onlineshop.payment.infrastructure.transversal.transform.PaymentTransform;
import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.PayURequest;
import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.PayUResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @EqualsAndHashCode(callSuper = false)
public class CreatePaymentDTO extends PaymentDTO {
    private PayURequest requestMessage;
    private PayUResponse responseMessage;

    public CreatePaymentDTO(Payment payment){
        super(payment);
        PaymentTransform paymentTransform = PaymentTransform.builder()
                .build();
        this.requestMessage = (PayURequest) paymentTransform.transformPaymentStringToObject(payment.getRequestMessage(),new PayURequest());
        this.responseMessage = (PayUResponse) paymentTransform.transformPaymentStringToObject(payment.getResponseMessage(),new PayUResponse());
    }
}
