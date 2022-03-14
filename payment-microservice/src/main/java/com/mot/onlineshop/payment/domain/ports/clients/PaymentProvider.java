package com.mot.onlineshop.payment.domain.ports.clients;

import com.mot.onlineshop.payment.domain.models.Payment;

public interface PaymentProvider {
    public Payment postPaymentProvider(Payment payment);

    Payment refundPayment(Payment payment);
}
