package com.mot.onlineshop.payment.domain.services;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.domain.models.PaymentId;
import java.util.stream.Stream;


public interface PaymentService {

    public Payment createPayment(Payment payment);

    public Stream<Payment> getPaymentsAll();

    public Payment getPaymentReference(PaymentId paymentReference);
}
