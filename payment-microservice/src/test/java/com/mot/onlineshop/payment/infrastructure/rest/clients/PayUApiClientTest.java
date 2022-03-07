package com.mot.onlineshop.payment.infrastructure.rest.clients;

import com.mot.onlineshop.payment.domain.interfaces.IPaymentRequest;
import com.mot.onlineshop.payment.domain.interfaces.IPaymentResponse;
import com.mot.onlineshop.payment.infrastructure.rest.DAOS.RequestPayURetrofitDAO;
import com.mot.onlineshop.payment.infrastructure.rest.constants.PaymentConstants;
import com.mot.onlineshop.payment.infrastructure.rest.mappers.PaymentMapper;
import com.mot.onlineshop.payment.infrastructure.rest.models.PayURequest;
import com.mot.onlineshop.payment.infrastructure.rest.models.PayUResponse;
import com.mot.onlineshop.payment.infrastructure.rest.models.transactionresponse.TransactionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
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
        payUResponse = new PayUResponse();
        payUResponse = new PayUResponse();
        payUResponse.setCode("SUCCESS");
        payUResponse.setError(null);
        payUResponse.setTransactionResponse(
                new TransactionResponse()
        );
        Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance(PaymentConstants.PAYU_URL);
        RequestPayURetrofitDAO requestPayURetrofitDAO = retrofit.create(RequestPayURetrofitDAO.class);
        PaymentMapper paymentTransform = PaymentMapper.builder()
                .build();
         payURequest = (PayURequest) paymentTransform.transformPaymentStringToObject(
                PaymentConstants.PAYMENTREQUEST,
                new PayURequest()
        );
        System.out.println("payURequest:"+payURequest);
        payUResponseCall =  requestPayURetrofitDAO.postRequestPayU(payURequest);
        System.out.println("payUResponseCall:"+payUResponseCall);
    }

    @Test
    void sendRequestPayU() throws IOException {
        when(requestPayURetrofitDAO.postRequestPayU(any(PayURequest.class))).thenReturn(payUResponseCall);
        PayUResponse payUResponseT = (PayUResponse) payUApiClient.sendRequestPayU(payURequest);
        assertNotNull(payUResponseT);
        assertEquals(payUResponse, payUResponseT);
    }
}