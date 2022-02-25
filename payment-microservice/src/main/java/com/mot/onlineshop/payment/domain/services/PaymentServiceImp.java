package com.mot.onlineshop.payment.domain.services;

import java.util.stream.Stream;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.domain.models.PaymentId;
import com.mot.onlineshop.payment.domain.persistence_ports.PaymentPersistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImp implements PaymentService{

    @Autowired
    PaymentPersistence paymentRepository;

    @Override
    public Payment createPayment(Payment payment) {
        System.out.println(payment.toString());
        return null;
    }

    @Override
    public Stream<Payment> getPaymentsAll() {
        return this.paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentReference(PaymentId paymentReference) {
        return this.paymentRepository.findByPaymentReference(paymentReference);
    }
}
