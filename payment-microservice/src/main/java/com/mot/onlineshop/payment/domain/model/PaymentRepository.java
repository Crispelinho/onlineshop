package com.mot.onlineshop.payment.domain.model;

import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface PaymentRepository {
    PaymentId getId();
    Payment findById(PaymentId id);
    void persist(Payment event);
    Stream<Payment> readAll();
}
