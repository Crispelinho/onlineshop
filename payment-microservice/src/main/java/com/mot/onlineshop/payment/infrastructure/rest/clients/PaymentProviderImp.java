package com.mot.onlineshop.payment.infrastructure.rest.clients;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.domain.ports.clients.ApiClient;
import com.mot.onlineshop.payment.domain.ports.persistence.InMemoryPersistence;
import com.mot.onlineshop.payment.domain.ports.clients.PaymentProvider;
import com.mot.onlineshop.payment.infrastructure.rest.transform.PaymentTransform;
import com.mot.onlineshop.payment.infrastructure.rest.models.PayURequest;
import com.mot.onlineshop.payment.infrastructure.rest.models.PayUResponse;
import com.mot.onlineshop.payment.infrastructure.rest.models.merchant.Merchant;
import com.mot.onlineshop.payment.infrastructure.rest.models.payer.Payer;
import com.mot.onlineshop.payment.infrastructure.rest.models.transacction.CreditCard;
import com.mot.onlineshop.payment.infrastructure.rest.models.transacction.Order;
import com.mot.onlineshop.payment.infrastructure.rest.models.transacction.Transaction;
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

    private static Logger log = LogManager.getLogger(PaymentProviderImp.class);

    @Override
    public Payment getPaymentProvider(Payment payment) {
        String methodSignature = "Inicializando método getPaymentProvider";
        log.info(methodSignature);
        Order order = inMemoryPersistence.getOrder(payment.getOrderReference());
        Payer payer = inMemoryPersistence.getPayer("1");
        CreditCard creditCard = inMemoryPersistence.getCreditCard("4037997623271984");
        Merchant merchant = inMemoryPersistence.getMerchant("1");
        Transaction transaction = new Transaction(order,payer,creditCard,"AUTHORIZATION_AND_CAPTURE","VISA","CO");
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
