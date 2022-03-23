package com.mot.onlineshop.payment.infrastructure.adapters.rest.clients;

import com.mot.onlineshop.payment.domain.ports.clients.ApiClient;
import com.mot.onlineshop.payment.domain.interfaces.IPaymentRequest;
import com.mot.onlineshop.payment.domain.interfaces.IPaymentResponse;
import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.*;
import com.mot.onlineshop.payment.infrastructure.transversal.constants.PaymentConstants;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component @AllArgsConstructor
public class ApiClientImp implements ApiClient {

    @Autowired
    private PayUApiClient payUApiClient;

    private static Logger log = LogManager.getLogger(PayUApiClient.class);

    @Override
    public IPaymentResponse post(IPaymentRequest payload, String target) throws IOException {
        String methodSignature = PaymentConstants.INITIALIZATION_METHOD + " sendRequestPayU";
        log.debug(methodSignature);

        switch (target){
            case  PaymentConstants.TRANSACTION_IN_PROCESS_PAYMENT:
                PayURequestPayment payURequestPayment = (PayURequestPayment) payload;
                return payUApiClient.sendRequestPayU(payURequestPayment);

            case PaymentConstants.TRANSACTION_IN_PROCESS_REFUND:
                PayURequestRefund payURequestRefund = (PayURequestRefund) payload;
                return payUApiClient.sendRequestPayURefund(payURequestRefund);
        }
        return null;
    }
}
