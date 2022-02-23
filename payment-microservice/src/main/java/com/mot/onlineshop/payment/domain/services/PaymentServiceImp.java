package com.mot.onlineshop.payment.domain.services;

import com.mot.onlineshop.payment.domain.model.Payment;
import com.mot.onlineshop.payment.domain.model.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;

public class PaymentServiceImp implements PaymentService{
    @Autowired
    PaymentRepository paymentRepository;

    public PaymentServiceImp(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment createPayment(Payment payment) {
        System.out.println(payment.toString());
        return null;
    }

    @Override
    public Stream<Payment> getPaymentsAll() {
        return this.paymentRepository.readAll();
    }
}
