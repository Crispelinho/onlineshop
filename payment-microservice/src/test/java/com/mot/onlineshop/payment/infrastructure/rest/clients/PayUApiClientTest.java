package com.mot.onlineshop.payment.infrastructure.rest.clients;

import com.mot.onlineshop.payment.domain.interfaces.IPaymentRequest;
import com.mot.onlineshop.payment.infrastructure.rest.DAOS.RequestPayURetrofitDAO;
import com.mot.onlineshop.payment.infrastructure.rest.models.PayURequest;
import com.mot.onlineshop.payment.infrastructure.rest.models.PayUResponse;
import com.mot.onlineshop.payment.infrastructure.rest.models.transactionresponse.TransactionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import retrofit2.Call;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

class PayUApiClientTest {

    @Mock
    private RequestPayURetrofitDAO requestPayURetrofitDAO;

    @InjectMocks
    private PayUApiClient payUApiClient;

    private PayUResponse payUResponse;

    private Call<PayUResponse> payUResponseCall;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        payUResponse = new PayUResponse();
        payUResponse = new PayUResponse();
        payUResponse.setCode("SUCCESS");
        payUResponse.setError(null);
        payUResponse.setTransactionResponse(
                new TransactionResponse()
        );

    }

    @Test
    void sendRequestPayU() throws IOException {
        when(requestPayURetrofitDAO.postRequestPayU(any(PayURequest.class))).thenReturn(payUResponseCall);
        assertNotNull(payUApiClient.sendRequestPayU(new PayURequest()));
    }
}