package com.mot.onlineshop.payment.infrastructure.rest.clients;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.domain.ports.clients.ApiClient;
import com.mot.onlineshop.payment.infrastructure.models.converters.ModelConverter;
import com.mot.onlineshop.payment.infrastructure.models.shared.Config;
import com.mot.onlineshop.payment.infrastructure.models.shared.orderms.Order;
import com.mot.onlineshop.payment.infrastructure.models.shared.userms.Person;
import com.mot.onlineshop.payment.infrastructure.persistence.memory.InMemoryPersistence;
import com.mot.onlineshop.payment.domain.ports.clients.PaymentProvider;
import com.mot.onlineshop.payment.infrastructure.rest.transform.PaymentTransform;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayURequest;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayUResponse;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.merchant.Merchant;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.payer.Payer;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.transaction.CreditCard;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.transaction.PayUOrder;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.transaction.Transaction;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component @AllArgsConstructor @NoArgsConstructor
public class PaymentProviderImp implements PaymentProvider {

    @Autowired
    private InMemoryPersistence inMemoryPersistence;

    @Autowired
    private ApiClient<PayUResponse, PayURequest> apiClient;

    @Autowired
    private ModelConverter modelConverter;

    private static Logger log = LogManager.getLogger(PaymentProviderImp.class);

    @Override
    public Payment getPaymentProvider(Payment payment) {
        String methodSignature = "Inicializando método getPaymentProvider";
        log.info(methodSignature);
        Order order = inMemoryPersistence.getOrder(payment.getOrderReference());
        Person person = inMemoryPersistence.getPerson(order.getDniNumber());
        CreditCard creditCard = inMemoryPersistence.getCreditCard("4037997623271984");
        PayUOrder payUOrder = modelConverter.converter(order);
        Config config = inMemoryPersistence.getConfig("PayU");
        payUOrder.setAccountId(config.getAccountId());
        payUOrder.setLanguage(config.getLanguage());
        payUOrder.setNotifyUrl(config.getNotifyUrl());
        payUOrder.setSignature("1d6c33aed575c4974ad5c0be7c6a1c87");
        payUOrder.setDescription("Payment test description");
        payUOrder.setReferenceCode("PRODUCT_TEST_2021-06-23T19:59:43.229Z");
        Merchant merchant = new Merchant(config.getApiKey(),config.getApiLogin());
        Payer payer = modelConverter.converter(person);

        Transaction transaction = new Transaction(payUOrder,payer,creditCard,"AUTHORIZATION_AND_CAPTURE","VISA",payment.getPaymentCountry());
        PayURequest payload = new PayURequest();
        payload.setLanguage("es");
        payload.setCommand("SUBMIT_TRANSACTION");
        payload.setMerchant(merchant);
        payload.setTransaction(transaction);
        payload.setTest(true);
        PayUResponse response = new PayUResponse();
        PaymentTransform paymentMapper = new PaymentTransform();
        String jsonResponse = null;
        try{
            response = apiClient.sendRequestPayU(payload);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        String jsonRequest = paymentMapper.transformPaymentObjectToString(payload);
        jsonResponse = paymentMapper.transformPaymentObjectToString(response);
        payment.setRequestMessage(jsonRequest);
        payment.setResponseMessage(jsonResponse);

        log.info("RequestMessage:"+payment.getRequestMessage());
        log.info("ResponseMessage:"+payment.getResponseMessage());

        return payment;
    }
}
