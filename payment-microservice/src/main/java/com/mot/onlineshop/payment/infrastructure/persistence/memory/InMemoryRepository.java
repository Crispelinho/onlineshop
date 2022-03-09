package com.mot.onlineshop.payment.infrastructure.persistence.memory;

import com.mot.onlineshop.payment.domain.ports.persistence.InMemoryPersistence;
import com.mot.onlineshop.payment.infrastructure.rest.models.merchant.Merchant;
import com.mot.onlineshop.payment.infrastructure.rest.models.payer.BillingAddress;
import com.mot.onlineshop.payment.infrastructure.rest.models.payer.Payer;
import com.mot.onlineshop.payment.infrastructure.rest.models.transacction.*;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryRepository implements InMemoryPersistence {

    @Override
    public Order getOrder(String orderReference) {
        Order order = new Order();
        order.setAccountId("512321");
        order.setReferenceCode("PRODUCT_TEST_2021-06-23T19:59:43.229Z");  //OrderId+date
        order.setDescription("Payment test description");
        order.setLanguage("es");
        order.setSignature("1d6c33aed575c4974ad5c0be7c6a1c87"); //MD5
        order.setNotifyUrl("http://www.payu.com/notify");
        TX TX_VALUE = new TX(65000,"COP");
        TX TX_TAX = new TX(10378,"COP");
        TX TX_TAX_RETURN_BASE = new TX(54622, "COP");
        AdditionalValues additionalValues = new AdditionalValues(TX_VALUE,TX_TAX,TX_TAX_RETURN_BASE);
        order.setAdditionalValues(additionalValues);
        ShippingAddress shippingAddressBuyer = new ShippingAddress("Cr 23 No. 53-50","5555487","Bogotá","Bogotá D.C.","CO","000000","7563126");
        ShippingAddress shippingAddress = new ShippingAddress("Cr 23 No. 53-50","5555487","Bogotá","Bogotá D.C.","CO","0000000","7563126");
        order.setBuyer(new Buyer("1","First name and second buyer name","buyer_test@test.com","7563126","123456789",
                shippingAddressBuyer));
        order.setShippingAddress(shippingAddress);
        return order;
    }

    @Override
    public Payer getPayer(String id) {
        Payer payer = new Payer();
        payer.setMerchantPayerId("1"); //Static
        payer.setFullName("First name and second payer name");
        payer.setEmailAddress("payer_test@test.com");
        payer.setContactPhone("7563126");
        payer.setBillingAddress(new BillingAddress("Cr 23 No. 53-50","125544","Bogotá","Bogotá D.C.","CO","000000","7563126"));
        return payer;
    }

    @Override
    public CreditCard getCreditCard(String id) {
        CreditCard creditCard = new CreditCard("4037997623271984","321","2030/12","APPROVED");
        return creditCard;
    }

    @Override
    public Merchant getMerchant(String id) {
        Merchant merchant = new Merchant("4Vj8eK4rloUd272L48hsrarnUA","pRRXKOl8ikMmt9u");
        return merchant;
    }
}
