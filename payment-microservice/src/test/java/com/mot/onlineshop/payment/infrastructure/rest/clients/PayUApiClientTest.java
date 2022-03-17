package com.mot.onlineshop.payment.infrastructure.rest.clients;

import com.mot.onlineshop.payment.infrastructure.rest.clients.retrofit.RequestPayURetrofitDAO;
import com.mot.onlineshop.payment.infrastructure.constants.PaymentConstantsTest;
import com.mot.onlineshop.payment.infrastructure.transform.PaymentTransform;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayURequest;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayUResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import retrofit2.Call;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;

class PayUApiClientTest {

    @Mock
    private RequestPayURetrofitDAO requestPayURetrofitDAO;

    @InjectMocks
    private PayUApiClient payUApiClient;

    private PayURequest payURequest;

    private PayUResponse payUResponse;

    private Call<PayUResponse> payUResponseCall;

    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        PaymentTransform paymentTransform = PaymentTransform.builder()
                .build();
        payUResponse = (PayUResponse) paymentTransform.transformPaymentStringToObject(
                PaymentConstantsTest.PAYMENTRESPONSE,
                new PayUResponse()
        );
         payURequest = (PayURequest) paymentTransform.transformPaymentStringToObject(
                 PaymentConstantsTest.PAYMENTREQUEST,
                new PayURequest()
        );
        System.out.println("payURequest:"+payURequest);
        System.out.println("payUResponse:"+payUResponse);

    }

    @Test
    void sendRequestPayU() throws IOException {
     // when(requestPayURetrofitDAO.postRequestPayU(payURequest)).thenReturn((Call<PayUResponse>) payUResponse);
        PayUResponse payUResponseT = (PayUResponse) payUApiClient.sendRequestPayU(payURequest);
        assertNotNull(payUResponseT);
        //assertEquals(payUResponse, payUResponseT);
    }
}









