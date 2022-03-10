package com.mot.onlineshop.payment.infrastructure.rest.DAOS;

import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayURequest;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayUResponse;
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

}
