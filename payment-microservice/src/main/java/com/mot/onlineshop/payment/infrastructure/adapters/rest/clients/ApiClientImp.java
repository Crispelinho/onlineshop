package com.mot.onlineshop.payment.infrastructure.adapters.rest.clients;

import com.mot.onlineshop.payment.domain.ports.clients.ApiClient;
import com.mot.onlineshop.payment.domain.interfaces.IPaymentRequest;
import com.mot.onlineshop.payment.domain.interfaces.IPaymentResponse;
import com.mot.onlineshop.payment.infrastructure.adapters.rest.clients.retrofit.RetrofitClientInstance;
import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.PayURequestRefund;
import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.PayUResponseRefund;
import com.mot.onlineshop.payment.infrastructure.transversal.constants.PaymentConstants;
import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.PayURequest;
import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.PayUResponse;
import com.mot.onlineshop.payment.infrastructure.adapters.rest.clients.retrofit.RequestPayURetrofitDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

@Component
public class ApiClientImp implements ApiClient {

    private static Logger log = LogManager.getLogger(PayUApiClient.class);

    @Override
    public IPaymentResponse sendRequestPayU(IPaymentRequest payload) throws IOException {
        String methodSignature = "Initialization method sendRequestPayU";
        log.debug(methodSignature);
        Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance(PaymentConstants.BASE_PAYU_URL);
        RequestPayURetrofitDAO requestPayURetrofitDAO = retrofit.create(RequestPayURetrofitDAO.class);

        PayURequest payURequest = (PayURequest) payload;
        switch (payURequest.getTransaction().getPaymentMethod()){
            case "VISA":
                Call<PayUResponse> requestPayUCall =  requestPayURetrofitDAO.postRequestPayU((PayURequest) payload);
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
    public IPaymentResponse sendRequestPayURefund(IPaymentRequest payload) throws IOException {
        String methodSignature = "Initialization method sendRequestPayURefund";
        log.info(methodSignature);
        Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance(PaymentConstants.BASE_PAYU_URL);
        RequestPayURetrofitDAO requestPayURetrofitDAO = retrofit.create(RequestPayURetrofitDAO.class);
        Call<PayUResponseRefund> responseRefundCall =  requestPayURetrofitDAO.postRequestPayURefund((PayURequestRefund) payload);
        Response<PayUResponseRefund> execute = responseRefundCall.execute();
        return execute.body();
    }
}
