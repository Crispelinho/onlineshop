package com.mot.onlineshop.payment.infrastructure.persistence.memory;

import com.mot.onlineshop.payment.infrastructure.models.shared.Config;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.merchant.Merchant;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.transaction.CreditCard;
import com.mot.onlineshop.payment.infrastructure.models.shared.orderms.Order;
import com.mot.onlineshop.payment.infrastructure.models.shared.userms.Person;

public interface InMemoryPersistence {
    public Order getOrder(String orderReference);
    public Person getPerson(String dniNumber);
    public CreditCard getCreditCard(String id);
    public Config getConfig(String provider);
}
