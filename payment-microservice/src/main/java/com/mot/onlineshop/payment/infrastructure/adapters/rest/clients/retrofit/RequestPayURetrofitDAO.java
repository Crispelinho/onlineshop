package com.mot.onlineshop.payment.infrastructure.rest.clients.retrofit;

import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayURequest;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayURequestRefund;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayUResponse;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayUResponseRefund;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import java.io.IOException;

public interface RequestPayURetrofitDAO{
    @Headers({
            "Accept: application/json",
    })
    @POST("payments-api/4.0/service.cgi")
    Call<PayUResponse> postRequestPayU(@Body PayURequest payURequest) throws IOException;

    @Headers({
            "Accept: application/json",
    })
    @POST("payments-api/4.0/service.cgi")
    Call<PayUResponseRefund> postRequestPayURefund(@Body PayURequestRefund payURequestRefund) throws IOException;
}
