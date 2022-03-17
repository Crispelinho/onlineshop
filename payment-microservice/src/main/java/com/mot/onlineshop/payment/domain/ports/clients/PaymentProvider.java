package com.mot.onlineshop.payment.domain.ports.clients;

import com.mot.onlineshop.payment.domain.models.payment.Payment;

public interface PaymentProvider {
    Payment postPaymentProvider(Payment payment);

    Payment refundPayment(Payment payment);
}
