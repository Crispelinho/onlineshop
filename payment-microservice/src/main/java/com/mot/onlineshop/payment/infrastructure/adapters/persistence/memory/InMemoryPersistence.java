package com.mot.onlineshop.payment.infrastructure.persistence.memory;

import com.mot.onlineshop.payment.infrastructure.models.shared.Config;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.transaction.CreditCard;
import com.mot.onlineshop.payment.infrastructure.models.shared.orderms.Order;
import com.mot.onlineshop.payment.infrastructure.models.shared.userms.Person;

public interface InMemoryPersistence {
    Order getOrder(String orderReference);
    Person getPerson(String dniNumber);
    CreditCard getCreditCard(String id);
    Config getConfig(String provider);
}
