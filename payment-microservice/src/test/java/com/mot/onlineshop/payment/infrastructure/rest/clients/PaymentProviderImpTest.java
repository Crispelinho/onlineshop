package com.mot.onlineshop.payment.infrastructure.rest.clients;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.domain.ports.clients.ApiClient;
import com.mot.onlineshop.payment.domain.ports.persistence.InMemoryPersistence;
import com.mot.onlineshop.payment.infrastructure.rest.models.PayURequest;
import com.mot.onlineshop.payment.infrastructure.rest.models.PayUResponse;
import com.mot.onlineshop.payment.infrastructure.rest.models.transactionresponse.TransactionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PaymentProviderImpTest {
    @Mock
    private InMemoryPersistence inMemoryPersistence;
    @Mock
    private ApiClient<PayUResponse, PayURequest> apiClient;

    @InjectMocks
    private PaymentProviderImp paymentProviderImp;

    private PayURequest payURequest;
    private PayUResponse payUResponse;
    private Payment payment;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        payUResponse = new PayUResponse();
        payUResponse.setCode("SUCCESS");
        payUResponse.setError(null);
        payUResponse.setTransactionResponse(
                new TransactionResponse()
        );
        payment = new Payment("TC",23.0,null,"a4518c77-8884-4af9-bcf1-15d1bcf07b90");
    }

    @Test
    void getPaymentProvider() throws IOException {
        when(apiClient.sendRequestPayU(any(PayURequest.class))).thenReturn(payUResponse);
        assertNotNull(paymentProviderImp.getPaymentProvider(new Payment()));
    }
}