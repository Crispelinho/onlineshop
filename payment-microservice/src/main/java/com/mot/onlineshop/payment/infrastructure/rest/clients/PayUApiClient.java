package com.mot.onlineshop.payment.infrastructure.rest.clients;

import com.mot.onlineshop.payment.domain.ports.clients.ApiClient;
import com.mot.onlineshop.payment.domain.interfaces.IPaymentRequest;
import com.mot.onlineshop.payment.domain.interfaces.IPaymentResponse;
import com.mot.onlineshop.payment.infrastructure.rest.constants.PaymentConstants;
import com.mot.onlineshop.payment.infrastructure.rest.transform.PaymentTransform;
import com.mot.onlineshop.payment.infrastructure.rest.models.PayURequest;
import com.mot.onlineshop.payment.infrastructure.rest.models.PayUResponse;
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
        Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance(PaymentConstants.PAYU_URL);
        RequestPayURetrofitDAO requestPayURetrofitDAO = retrofit.create(RequestPayURetrofitDAO.class);
        PaymentTransform paymentMapper = new PaymentTransform();
        log.info(paymentMapper.transformPaymentObjectToString(payload));
        Call<PayUResponse> requestPayUCall =  requestPayURetrofitDAO.postRequestPayU((PayURequest) payload);
        Response<PayUResponse> execute = requestPayUCall.execute();
        //log.info("execute:"+execute);
        return execute.body();
    }
}
