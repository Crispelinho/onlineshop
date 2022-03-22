package com.mot.onlineshop.payment.infrastructure.rest.api.DTOs;

import com.mot.onlineshop.payment.domain.models.payment.Payment;
import com.mot.onlineshop.payment.infrastructure.transform.PaymentTransform;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayURequest;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayUResponse;
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
