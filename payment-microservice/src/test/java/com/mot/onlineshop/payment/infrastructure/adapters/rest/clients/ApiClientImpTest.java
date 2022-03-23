package com.mot.onlineshop.payment.infrastructure.adapters.rest.clients;

import com.mot.onlineshop.payment.infrastructure.adapters.rest.clients.retrofit.RequestPayURetrofitDAO;
import com.mot.onlineshop.payment.infrastructure.transversal.constants.PaymentConstants;
import com.mot.onlineshop.payment.infrastructure.transversal.constants.PaymentConstantsTest;
import com.mot.onlineshop.payment.infrastructure.transversal.transform.PaymentTransform;
import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.PayURequest;
import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.PayUResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import retrofit2.Call;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;

class ApiClientImpTest {

    @Mock
    private RequestPayURetrofitDAO requestPayURetrofitDAO;

    @InjectMocks
    private ApiClientImp apiClientImp;

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
        PayUResponse payUResponseT = (PayUResponse) apiClientImp.post(payURequest, PaymentConstants.TRANSACTION_IN_PROCESS_PAYMENT);
        assertNotNull(payUResponseT);
        //assertEquals(payUResponse, payUResponseT);
    }
}