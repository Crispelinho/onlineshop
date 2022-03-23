package com.mot.onlineshop.payment.infrastructure.adapters.rest.clients;

import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.PayURequestPayment;
import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.PayURequestRefund;
import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.PayUResponse;

import java.io.IOException;

public interface PayUApiClient {
    PayUResponse sendRequestPayU(PayURequestPayment payload) throws IOException;
    PayUResponse sendRequestPayURefund(PayURequestRefund payload) throws IOException;
}
