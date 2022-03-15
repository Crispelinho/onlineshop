package com.mot.onlineshop.payment.infrastructure.rest.DTO;

import com.mot.onlineshop.payment.domain.models.payment.Payment;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayURequest;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayURequestRefund;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayUResponse;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayUResponseRefund;
import com.mot.onlineshop.payment.infrastructure.rest.transform.PaymentTransform;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RefundPaymentDTO extends PaymentDTO{
    private PayURequestRefund requestMessage;
    private PayUResponseRefund responseMessage;

    public RefundPaymentDTO(Payment payment){
        super(payment);
        PaymentTransform paymentTransform = PaymentTransform.builder()
                .build();
        this.requestMessage = (PayURequestRefund) paymentTransform.transformPaymentStringToObject(payment.getRequestMessage(),new PayURequest());
        this.responseMessage = (PayUResponseRefund) paymentTransform.transformPaymentStringToObject(payment.getResponseMessage(),new PayUResponse());
    }
}
