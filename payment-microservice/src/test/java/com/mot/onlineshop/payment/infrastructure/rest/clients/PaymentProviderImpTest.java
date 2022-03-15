package com.mot.onlineshop.payment.infrastructure.rest.clients;

import com.mot.onlineshop.payment.domain.models.payment.Payment;
import com.mot.onlineshop.payment.domain.ports.clients.ApiClient;
import com.mot.onlineshop.payment.infrastructure.models.converters.ModelConverter;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.payer.BillingAddress;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.payer.Payer;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.transaction.*;
import com.mot.onlineshop.payment.infrastructure.models.shared.Config;
import com.mot.onlineshop.payment.infrastructure.models.shared.orderms.Order;
import com.mot.onlineshop.payment.infrastructure.models.shared.userms.Person;
import com.mot.onlineshop.payment.infrastructure.persistence.memory.InMemoryPersistence;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayURequest;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayUResponse;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.transactionresponse.TransactionResponse;
import com.mot.onlineshop.payment.infrastructure.rest.constants.PaymentConstantsTest;
import com.mot.onlineshop.payment.infrastructure.rest.transform.PaymentTransform;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PaymentProviderImpTest {
    @Mock
    private InMemoryPersistence inMemoryPersistence;
    @Mock
    private ApiClient<PayUResponse, PayURequest> apiClient;
    @Mock
    private ModelConverter modelConverter;

    @InjectMocks
    private PaymentProviderImp paymentProviderImp;

    private PayURequest payURequest;
    private PayUResponse payUResponse;
    private Payment payment;
    private Order order;
    private Person person;
    private Config config;
    private CreditCard creditCard;
    private PayUOrder payUOrder;
    private Payer payer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        PaymentTransform paymentTransform = PaymentTransform.builder().build();
        payURequest = (PayURequest) paymentTransform.transformPaymentStringToObject(PaymentConstantsTest.PAYMENTREQUEST,new PayURequest());
        payUResponse = (PayUResponse) paymentTransform.transformPaymentStringToObject(PaymentConstantsTest.PAYMENTRESPONSE,new PayUResponse());

        // payUResponse = new PayUResponse();
       // payUResponse.setCode("SUCCESS");
       // payUResponse.setError(null);
       // payUResponse.setTransactionResponse(
       //         new TransactionResponse());
        payment = new Payment("TC",23.0,"CO",null,null,null,"a4518c77-8884-4af9-bcf1-15d1bcf07b90");
        payment.getPaymentReference().setId(UUID.randomUUID());
        payment.setDatetimePayment(LocalDateTime.now(ZoneId.of("UTC")).minusHours(5L));
        order = new Order();
        TX TX_VALUE = new TX(65000,"COP");
        TX TX_TAX = new TX(10378,"COP");
        TX TX_TAX_RETURN_BASE = new TX(54622, "COP");
        AdditionalValues additionalValues = new AdditionalValues(TX_VALUE,TX_TAX,TX_TAX_RETURN_BASE);
        ShippingAddress shippingAddressBuyer = new ShippingAddress("Cr 23 No. 53-50","5555487","Bogotá","Bogotá D.C.","CO","000000","7563126");
        ShippingAddress shippingAddress = new ShippingAddress("Cr 23 No. 53-50","5555487","Bogotá","Bogotá D.C.","CO","0000000","7563126");
        order.setOrderReference(UUID.fromString("a4518c77-8884-4af9-bcf1-15d1bcf07b90"));
        order.setDateTime(LocalDateTime.now(ZoneId.of("UTC")));
        order.setAdditionalValues(additionalValues);
        order.setDniNumber("1082000345");
        order.setBuyer(new Buyer("1","First name and second buyer name","buyer_test@test.com","7563126","123456789",
                shippingAddressBuyer));
        order.setShippingAddress(shippingAddress);

        person = new Person();
        person.setMerchantPayerId("1"); //Static
        person.setFirstname("Cristhian");
        person.setLastname("Carpio");
        person.setEmailAddress("payer_test@test.com");
        person.setContactPhone("7563126");
        person.setBillingAddress(new BillingAddress("Cr 23 No. 53-50","125544","Bogotá","Bogotá D.C.","CO","000000","7563126"));

        creditCard = new CreditCard("4037997623271984","321","2030/12","APPROVED");

        config = new Config();
        config.setApiKey("4Vj8eK4rloUd272L48hsrarnUA");
        config.setApiLogin("pRRXKOl8ikMmt9u");
        config.setAccountId("512321");
        config.setLanguage("es");
        config.setNotifyUrl("http://www.payu.com/notify");

        payUOrder = new PayUOrder();
        payUOrder.setAdditionalValues(additionalValues);
        payUOrder.setBuyer(new Buyer("1","First name and second buyer name","buyer_test@test.com","7563126","123456789",
                shippingAddressBuyer));
        payUOrder.setShippingAddress(shippingAddress);

        payUOrder.setAccountId(config.getAccountId());
        payUOrder.setLanguage(config.getLanguage());
        payUOrder.setNotifyUrl(config.getNotifyUrl());
        payUOrder.setSignature("1d6c33aed575c4974ad5c0be7c6a1c87");
        payUOrder.setDescription("Payment test description");
        payUOrder.setReferenceCode("PRODUCT_TEST_2021-06-23T19:59:43.229Z");
        System.out.println(payUOrder);
        payer = modelConverter.converter(person);

    }

    @Test
    void getPaymentProvider() throws IOException {
        when(apiClient.sendRequestPayU(payURequest)).thenReturn(payUResponse);
        when(inMemoryPersistence.getOrder("a4518c77-8884-4af9-bcf1-15d1bcf07b90")).thenReturn(order);
        when(inMemoryPersistence.getPerson("1")).thenReturn(person);
        when(inMemoryPersistence.getCreditCard("1")).thenReturn(creditCard);
        when(inMemoryPersistence.getConfig("PayU")).thenReturn(config);
        when(modelConverter.converter(order)).thenReturn(payUOrder);
        when(modelConverter.converter(person)).thenReturn(payer);
        Payment paymentResponse = paymentProviderImp.postPaymentProvider(payment);
        payment.setRequestMessage(PaymentConstantsTest.PAYMENTREQUEST);
        payment.setResponseMessage(PaymentConstantsTest.PAYMENTREQUEST);
        assertNotNull(paymentResponse);
        assertEquals(payment,paymentResponse);
    }
}