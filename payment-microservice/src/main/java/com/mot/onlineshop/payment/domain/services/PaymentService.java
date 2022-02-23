package com.mot.onlineshop.payment.domain.services;

import com.mot.onlineshop.payment.domain.model.Payment;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public interface PaymentService {

    public Payment createPayment(Payment payment);

    Stream<Payment> getPaymentsAll();
}
