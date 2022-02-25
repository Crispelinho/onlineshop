package com.mot.onlineshop.payment.application.usecases;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.domain.persistence_ports.PaymentPersistence;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetPaymentUseCase {
    private PaymentPersistence paymentPersistence;
    public Payment handle(Payment payment) {
        return paymentPersistence.findByPaymentReference(payment.getPaymentReference());
    }
}
