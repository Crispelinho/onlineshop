package com.mot.onlineshop.payment.infrastructure.rest.DTO;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.infrastructure.rest.transform.PaymentTransform;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayURequest;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayUResponse;
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
    private PayURequest requestMessage;
    private PayUResponse responseMessage;

    public PaymentDTO(Payment payment){
        PaymentTransform paymentTransform = PaymentTransform.builder()
                .build();
        if(payment.getPaymentReference().getId() != null){
            this.paymentReference = payment.getPaymentReference().getId().toString();
        }
        if(payment.getPaymentMethod()!=null){
            this.paymentMethod = payment.getPaymentMethod().toString();
        }
        this.paymentValue = payment.getPaymentValue();
        this.paymentCountry = payment.getPaymentCountry();
        this.orderReference = payment.getOrderReference();
        this.requestMessage = (PayURequest) paymentTransform.transformPaymentStringToObject(payment.getRequestMessage(),new PayURequest());
        this.responseMessage = (PayUResponse) paymentTransform.transformPaymentStringToObject(payment.getResponseMessage(),new PayUResponse());
    }
}
