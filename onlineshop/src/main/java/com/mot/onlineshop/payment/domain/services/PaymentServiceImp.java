package com.mot.onlineshop.domain.services;

import com.mot.onlineshop.domain.model.Payment;
import com.mot.onlineshop.infrastructure.rest.DTO.PaymentDTO;

public class PaymentServiceImp implements PaymentService{
    @Override
    public Payment createPayment(Payment payment) {
        System.out.println(payment.toString());
        return null;
    }
}
