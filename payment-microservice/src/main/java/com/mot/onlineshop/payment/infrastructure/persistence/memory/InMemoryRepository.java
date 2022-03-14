package com.mot.onlineshop.payment.infrastructure.persistence.memory;

import com.mot.onlineshop.payment.infrastructure.models.shared.Config;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.merchant.Merchant;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.payer.BillingAddress;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.payer.Payer;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.transaction.*;
import com.mot.onlineshop.payment.infrastructure.models.shared.orderms.Order;
import com.mot.onlineshop.payment.infrastructure.models.shared.userms.Person;
import com.mot.onlineshop.payment.infrastructure.rest.clients.PaymentProviderImp;
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
        String methodSignature = "Inicializando método getOrder";
        log.info(methodSignature);
        Order order = new Order();
        TX TX_VALUE = new TX(65000,"COP");
        TX TX_TAX = new TX(10378,"COP");
        TX TX_TAX_RETURN_BASE = new TX(54622, "COP");
        AdditionalValues additionalValues = new AdditionalValues(TX_VALUE,TX_TAX,TX_TAX_RETURN_BASE);
        ShippingAddress shippingAddressBuyer = new ShippingAddress("Cr 23 No. 53-50","5555487","Bogotá","Bogotá D.C.","CO","000000","7563126");
        ShippingAddress shippingAddress = new ShippingAddress("Cr 23 No. 53-50","5555487","Bogotá","Bogotá D.C.","CO","0000000","7563126");
        log.info("orderReference: "+orderReference);
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
        String methodSignature = "Inicializando método getPayer";
        log.info(methodSignature);
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
        String methodSignature = "Inicializando método getCreditCard";
        log.info(methodSignature);
        CreditCard creditCard = new CreditCard("4037997623271984","321","2030/12","APPROVED");
        return creditCard;
    }

    //Consulta de información a MS-ServiceConfig
    @Override
    public Config getConfig(String provider){
        String methodSignature = "Inicializando método getConfig";
        log.info(methodSignature);
        Config config = new Config();
        config.setApiKey("4Vj8eK4rloUd272L48hsrarnUA");
        config.setApiLogin("pRRXKOl8ikMmt9u");
        config.setAccountId("512321");
        //config.setReferenceCode("PRODUCT_TEST_2021-06-23T19:59:43.229Z");  //OrderId+date
        config.setLanguage("es");
        //config.setSignature("1d6c33aed575c4974ad5c0be7c6a1c87"); //MD5
        config.setNotifyUrl("http://www.payu.com/notify");
        return config;
    }

}
