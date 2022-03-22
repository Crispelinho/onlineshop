package com.mot.onlineshop.payment.infrastructure.ports.rest.api.DTOs;

import com.mot.onlineshop.payment.domain.exceptions.constants.ExceptionsConstants;
import com.mot.onlineshop.payment.domain.models.payment.Payment;
import com.mot.onlineshop.payment.infrastructure.transversal.constants.PaymentConstants;
import com.mot.onlineshop.payment.infrastructure.adapters.models.shared.Payload;
import com.mot.onlineshop.payment.infrastructure.transversal.transform.PaymentTransform;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class PaymentDTO implements Serializable {
    private String paymentReference;
    @NotNull(message = ExceptionsConstants.PAYMENT_METHOD_NULL)
    @NotEmpty(message = ExceptionsConstants.PAYMENT_METHOD_NULL)
    private String paymentMethod;
    @NotNull(message = ExceptionsConstants.PAYMENT_VALUE_NULL)
    private Double paymentValue;
    private String paymentCountry;
    private String datetimePayment;
    @NotNull(message = ExceptionsConstants.ORDER_REFERENCE_NULL)
    @NotEmpty(message = ExceptionsConstants.ORDER_REFERENCE_NULL)
    @Pattern(regexp = PaymentConstants.UUID_REFERENCE_VALIDATION_PATTERN, message = ExceptionsConstants.INVALID_ORDER_REFERENCE)
    private String orderReference;
    private String description;
    private String status;
    private Payload payload;

    public PaymentDTO(Payment payment){
        PaymentTransform paymentTransform = PaymentTransform.builder()
                .build();
        if(payment.getPaymentReference().getId() != null){
            this.setPaymentReference(payment.getPaymentReference().getId().toString());
        }
        if(payment.getPaymentMethod()!=null){
            this.paymentMethod = payment.getPaymentMethod().toString();
        }
        this.description = payment.getDescription();
        this.paymentValue = payment.getPaymentValue();
        this.paymentCountry = payment.getPaymentCountry();
        this.orderReference = payment.getOrderReference();
        this.payload = (Payload) paymentTransform.transformPaymentStringToObject(payment.getPayload(),new Payload());
     }
}
