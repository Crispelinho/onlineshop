package com.mot.onlineshop.payment.infrastructure.models.converters;

import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.payer.Payer;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.transaction.PayUOrder;
import com.mot.onlineshop.payment.infrastructure.models.shared.orderms.Order;
import com.mot.onlineshop.payment.infrastructure.models.shared.userms.Person;

public interface ModelConverter {
    public PayUOrder converter(Order order);
    public Payer converter(Person person);
}
