package com.mot.onlineshop.payment.infrastructure.adapters.rest.clients;

import com.mot.onlineshop.payment.domain.interfaces.IPaymentRequest;
import com.mot.onlineshop.payment.domain.interfaces.IPaymentResponse;
import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.*;
import com.mot.onlineshop.payment.infrastructure.adapters.rest.clients.retrofit.RequestPayURetrofitDAO;
import com.mot.onlineshop.payment.infrastructure.adapters.rest.clients.retrofit.RetrofitClientInstance;
import com.mot.onlineshop.payment.infrastructure.transversal.constants.PaymentConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

@Component
public class PayUApiClientImp implements PayUApiClient{

    private static Logger log = LogManager.getLogger(PayUApiClientImp.class);

    @Override
    public PayUResponse sendRequestPayU(PayURequestPayment payload) throws IOException {
        Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance(PaymentConstants.BASE_PAYU_URL);
        RequestPayURetrofitDAO requestPayURetrofitDAO = retrofit.create(RequestPayURetrofitDAO.class);

        switch (payload.getTransaction().getPaymentMethod()){
            case "VISA":
                Call<PayUResponse> requestPayUCall =  requestPayURetrofitDAO.postRequestPayU(payload);
                Response<PayUResponse> execute = requestPayUCall.execute();
                return execute.body();
            case "TD":
                break;
            case "PSE":
                break;
        }
        return null;
    }

    @Override
    public PayUResponse sendRequestPayURefund(PayURequestRefund payload) throws IOException {
        Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance(PaymentConstants.BASE_PAYU_URL);
        RequestPayURetrofitDAO requestPayURetrofitDAO = retrofit.create(RequestPayURetrofitDAO.class);
        Call<PayUResponse> responseRefundCall =  requestPayURetrofitDAO.postRequestPayURefund((PayURequestRefund) payload);
        Response<PayUResponse> execute = responseRefundCall.execute();
        return execute.body();
    }
}
