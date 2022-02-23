package com.mot.onlineshop.payment.domain.services;

import com.mot.onlineshop.payment.domain.models.Payment;

import java.util.stream.Stream;


public interface PaymentService {

    public Payment createPayment(Payment payment);

    Stream<Payment> getPaymentsAll();
}
