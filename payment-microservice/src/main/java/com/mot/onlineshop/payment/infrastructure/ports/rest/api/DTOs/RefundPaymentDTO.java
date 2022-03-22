package com.mot.onlineshop.payment.infrastructure.rest.api.DTOs;

import com.mot.onlineshop.payment.domain.models.payment.Payment;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayURequest;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayURequestRefund;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayUResponse;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayUResponseRefund;
import com.mot.onlineshop.payment.infrastructure.transform.PaymentTransform;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data @EqualsAndHashCode(callSuper = false)
public class RefundPaymentDTO extends PaymentDTO{
    private PayURequestRefund requestMessage;
    private PayUResponseRefund responseMessage;

    public RefundPaymentDTO(){
        super();
       }
}
