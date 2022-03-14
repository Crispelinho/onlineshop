package com.mot.onlineshop.payment.domain.ports.clients;

import com.mot.onlineshop.payment.domain.interfaces.IPaymentRequest;
import com.mot.onlineshop.payment.domain.interfaces.IPaymentResponse;


import java.io.IOException;


public interface ApiClient <T extends IPaymentResponse, R extends IPaymentRequest>{

    public T sendRequestPayU(R paymentRequest) throws IOException;

    IPaymentResponse sendRequestPayURefund(IPaymentRequest payload) throws IOException;
}
