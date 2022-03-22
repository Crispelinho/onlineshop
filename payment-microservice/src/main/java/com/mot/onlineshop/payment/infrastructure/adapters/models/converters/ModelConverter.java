package com.mot.onlineshop.payment.infrastructure.adapters.models.converters;

import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.payer.Payer;
import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.transaction.PayUOrder;
import com.mot.onlineshop.payment.infrastructure.adapters.models.shared.orderms.Order;
import com.mot.onlineshop.payment.infrastructure.adapters.models.shared.userms.Person;

public interface ModelConverter {
    public PayUOrder converter(Order order);
    public Payer converter(Person person);
}
