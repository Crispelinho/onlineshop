package com.mot.onlineshop.payment.infrastructure.adapters.persistence.memory;

import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.transaction.*;
import com.mot.onlineshop.payment.infrastructure.adapters.models.shared.Config;
import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.payer.BillingAddress;
import com.mot.onlineshop.payment.infrastructure.adapters.models.shared.orderms.Order;
import com.mot.onlineshop.payment.infrastructure.adapters.models.shared.userms.Person;
import com.mot.onlineshop.payment.infrastructure.transversal.constants.PaymentConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Repository
public class InMemoryRepository implements InMemoryPersistence {

    private static Logger log = LogManager.getLogger(InMemoryRepository.class);

    @Override
    public Order getOrder(String orderReference) {
        String methodSignature = "Initialization method getOrder";
        log.debug(methodSignature);
        log.info(PaymentConstants.FIND_ORDER_WITH_ORDER_REFERENCE +"["+orderReference+"]");
        Order order = new Order();
        TX TX_VALUE = new TX(65000,"COP");
        TX TX_TAX = new TX(10378,"COP");
        TX TX_TAX_RETURN_BASE = new TX(54622, "COP");
        AdditionalValues additionalValues = new AdditionalValues(TX_VALUE,TX_TAX,TX_TAX_RETURN_BASE);
        ShippingAddress shippingAddressBuyer = new ShippingAddress("Cr 23 No. 53-50","5555487","Bogotá","Bogotá D.C.","CO","000000","7563126");
        ShippingAddress shippingAddress = new ShippingAddress("Cr 23 No. 53-50","5555487","Bogotá","Bogotá D.C.","CO","0000000","7563126");
        order.setOrderReference(UUID.fromString(orderReference));
        order.setDateTime(LocalDateTime.now(ZoneId.of("UTC")));
        order.setAdditionalValues(additionalValues);
        order.setDniNumber("1082000345");
        order.setBuyer(new Buyer("1","First name and second buyer name","buyer_test@test.com","7563126","123456789",
                shippingAddressBuyer));
        order.setShippingAddress(shippingAddress);
        return order;
    }

    @Override
    public Person getPerson(String id) {
        String methodSignature = "Initialization method getPayer";
        log.debug(methodSignature);
        log.info(PaymentConstants.FIND_PERSON_WITH_PERSON_ID +"["+id+"]");
        Person person = new Person();
        person.setMerchantPayerId("1"); //Static
        person.setFirstname("Cristhian");
        person.setLastname("Carpio");
        person.setEmailAddress("payer_test@test.com");
        person.setContactPhone("7563126");
        person.setBillingAddress(new BillingAddress("Cr 23 No. 53-50","125544","Bogotá","Bogotá D.C.","CO","000000","7563126"));
        return person;
    }

    @Override
    public CreditCard getCreditCard(String id) {
        String methodSignature = "Initialization method getCreditCard";
        log.debug(methodSignature);
        CreditCard creditCard = new CreditCard("4037997623271984","321","2030/12","APPROVED");
        return creditCard;
    }

    //Consulta de información a MS-ServiceConfig
    @Override
    public Config getConfig(String provider){
        String methodSignature = "Initialization method getConfig";
        log.debug(methodSignature);
        log.info(PaymentConstants.FIND_PROVIDER_WITH_REFERENCE +"["+provider+"]");
        Config config = new Config();
        config.setApiKey("4Vj8eK4rloUd272L48hsrarnUA");
        config.setApiLogin("pRRXKOl8ikMmt9u");
        config.setMerchantId("508029");
        config.setAccountId("512321");
        config.setLanguage("es");
        config.setNotifyUrl("http://www.payu.com/notify");
        return config;
    }

}
