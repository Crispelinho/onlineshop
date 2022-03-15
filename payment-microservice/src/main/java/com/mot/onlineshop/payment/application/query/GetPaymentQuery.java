package com.mot.onlineshop.payment.application.query;

import com.mot.onlineshop.payment.application.querybus.Query;
import com.mot.onlineshop.payment.domain.models.payment.Payment;
import lombok.*;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class GetPaymentQuery extends Query<Payment> {
    private Payment payment;

}
