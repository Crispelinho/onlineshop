package com.mot.onlineshop.payment.domain.services;

import com.mot.onlineshop.payment.domain.model.Payment;

public class PaymentServiceImp implements PaymentService{
    @Override
    public Payment createPayment(Payment payment) {
        System.out.println(payment.toString());
        return null;
    }
}
