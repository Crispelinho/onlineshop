package com.mot.onlineshop.payment.domain.ports.persistence;

import com.mot.onlineshop.payment.infrastructure.rest.models.merchant.Merchant;
import com.mot.onlineshop.payment.infrastructure.rest.models.payer.Payer;
import com.mot.onlineshop.payment.infrastructure.rest.models.transacction.CreditCard;
import com.mot.onlineshop.payment.infrastructure.rest.models.transacction.Order;

public interface InMemoryPersistence {
    public Order getOrder(String orderReference);
    public Payer getPayer(String id);
    public CreditCard getCreditCard(String id);
    public Merchant getMerchant(String id);
}
