package com.mot.onlineshop.payment.infrastructure.models.converters;

import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.payer.Payer;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.transaction.PayUOrder;
import com.mot.onlineshop.payment.infrastructure.models.shared.orderms.Order;
import com.mot.onlineshop.payment.infrastructure.models.shared.userms.Person;
import org.springframework.stereotype.Component;

@Component
public class ModelConverterImp implements ModelConverter {

    @Override
    public PayUOrder converter(Order order) {
        PayUOrder payUOrder = new PayUOrder();
        payUOrder.setBuyer(order.getBuyer());
        payUOrder.setReferenceCode(order.getOrderReference().toString()+order.getDateTime().toString());
        payUOrder.setShippingAddress(order.getShippingAddress());
        payUOrder.setDescription(order.getDescription());
        payUOrder.setAdditionalValues(order.getAdditionalValues());
        return payUOrder;
    }

    @Override
    public Payer converter(Person person) {
        Payer payer = new Payer();
        payer.setMerchantPayerId(person.getMerchantPayerId());
        payer.setFullName(person.getFirstname()+" "+person.getLastname());
        payer.setEmailAddress(person.getEmailAddress());
        payer.setContactPhone(person.getContactPhone());
        payer.setDniNumber(person.getDniNumber());
        payer.setBillingAddress(person.getBillingAddress());
        payer.setType(person.getType());
        return payer;
    }
}
