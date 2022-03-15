package com.mot.onlineshop.payment.infrastructure.rest.clients;

import com.mot.onlineshop.payment.domain.ports.clients.ApiClient;
import com.mot.onlineshop.payment.domain.interfaces.IPaymentRequest;
import com.mot.onlineshop.payment.domain.interfaces.IPaymentResponse;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayURequestRefund;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayUResponseRefund;
import com.mot.onlineshop.payment.infrastructure.rest.constants.PaymentConstants;
import com.mot.onlineshop.payment.infrastructure.rest.transform.PaymentTransform;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayURequest;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayUResponse;
import com.mot.onlineshop.payment.infrastructure.rest.DAOS.RequestPayURetrofitDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

@Component
public class PayUApiClient implements ApiClient {

    private static Logger log = LogManager.getLogger(PayUApiClient.class);

    @Override
    public IPaymentResponse sendRequestPayU(IPaymentRequest payload) throws IOException {
        String methodSignature = "Inicializando método sendRequestPayU";
        log.info(methodSignature);
        Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance(PaymentConstants.BASE_PAYU_URL);
        RequestPayURetrofitDAO requestPayURetrofitDAO = retrofit.create(RequestPayURetrofitDAO.class);
        PaymentTransform paymentTransform = new PaymentTransform();
        //log.info(paymentTransform.transformPaymentObjectToString(payload));

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
        //log.info("execute:"+execute);
        return null;
    }

    @Override
    public IPaymentResponse sendRequestPayURefund(IPaymentRequest payload) throws IOException {
        String methodSignature = "Inicializando método sendRequestPayURefund";
        log.info(methodSignature);
        Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance(PaymentConstants.BASE_PAYU_URL);
        RequestPayURetrofitDAO requestPayURetrofitDAO = retrofit.create(RequestPayURetrofitDAO.class);
        Call<PayUResponseRefund> responseRefundCall =  requestPayURetrofitDAO.postRequestPayURefund((PayURequestRefund) payload);
        Response<PayUResponseRefund> execute = responseRefundCall.execute();
        return execute.body();
    }
}
