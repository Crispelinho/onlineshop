package com.mot.onlineshop.domain.model.payment;

public interface PaymentRepository {
    PaymentId getId();

    Payment findById(PaymentId id);

    void persist(Payment event);
}
