package com.mot.onlineshop.payment.infrastructure.rest.DAOS;

import com.mot.onlineshop.payment.domain.interfaces.IPaymentRequest;
import com.mot.onlineshop.payment.domain.interfaces.IPaymentResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import java.io.IOException;

public interface RetrofitDAO <T extends IPaymentResponse, R extends IPaymentRequest>{
    @Headers({
            "Accept: application/json",
    })
    @POST("payments-api/4.0/service.cgi")
    Call<T> postRequest(@Body R request) throws IOException;
}
