package com.mot.onlineshop.payment.infrastructure.rest.clients;

import com.google.gson.Gson;
import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.domain.ports.clients.ApiClient;
import com.mot.onlineshop.payment.domain.ports.persistence.InMemoryPersistence;
import com.mot.onlineshop.payment.domain.ports.clients.PaymentProvider;
import com.mot.onlineshop.payment.infrastructure.rest.models.PayURequest;
import com.mot.onlineshop.payment.infrastructure.rest.models.PayUResponse;
import com.mot.onlineshop.payment.infrastructure.rest.models.merchant.Merchant;
import com.mot.onlineshop.payment.infrastructure.rest.models.payer.Payer;
import com.mot.onlineshop.payment.infrastructure.rest.models.transacction.CreditCard;
import com.mot.onlineshop.payment.infrastructure.rest.models.transacction.Order;
import com.mot.onlineshop.payment.infrastructure.rest.models.transacction.Transacction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component @AllArgsConstructor
public class PaymentProviderImp implements PaymentProvider {

    private InMemoryPersistence inMemoryPersistence;
    private ApiClient<PayUResponse, PayURequest> apiClient;

    @Override
    public Payment getPaymentProvider(Payment payment) {

        Order order = inMemoryPersistence.getOrder(payment.getOrderReference());
        Payer payer = inMemoryPersistence.getPayer("1");
        CreditCard creditCard = inMemoryPersistence.getCreditCard("4037997623271984");
        Merchant merchant = inMemoryPersistence.getMerchant("1");
        Transacction transacction = new Transacction(order,payer,creditCard,"AUTHORIZATION_AND_CAPTURE","VISA","CO");
        PayURequest payload = new PayURequest();
        payload.setLanguage("es");
        payload.setCommand("SUBMIT_TRANSACTION");
        payload.setMerchant(merchant);
        payload.setTransacction(transacction);
        payload.setTest(true);
        PayUResponse response = new PayUResponse();
        Gson gson = new Gson();
        try{
            response = apiClient.sendRequestPayU(payload);
            String json = gson.toJson(response);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        payment.setPayload(response.toString());
        return payment;
    }
}
