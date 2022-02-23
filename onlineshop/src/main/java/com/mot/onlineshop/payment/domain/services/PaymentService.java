package com.mot.onlineshop.domain.services;

import com.mot.onlineshop.domain.model.Payment;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {

    public Payment createPayment(Payment payment);
}
