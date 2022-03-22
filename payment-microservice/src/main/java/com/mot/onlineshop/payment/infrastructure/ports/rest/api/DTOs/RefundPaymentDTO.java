package com.mot.onlineshop.payment.infrastructure.ports.rest.api.DTOs;

import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.PayURequestRefund;
import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.PayUResponseRefund;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @EqualsAndHashCode(callSuper = false)
public class RefundPaymentDTO extends PaymentDTO{
    private PayURequestRefund requestMessage;
    private PayUResponseRefund responseMessage;

    public RefundPaymentDTO(){
        super();
       }
}
