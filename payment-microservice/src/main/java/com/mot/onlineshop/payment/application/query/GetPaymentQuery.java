package com.mot.onlineshop.payment.application.query;

import com.mot.onlineshop.payment.application.querybus.Query;
import com.mot.onlineshop.payment.domain.models.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class GetPaymentQuery extends Query<Payment> {
    private Payment payment;
}
