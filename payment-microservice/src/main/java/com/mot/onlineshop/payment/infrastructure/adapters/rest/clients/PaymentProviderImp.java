package com.mot.onlineshop.payment.infrastructure.adapters.rest.clients;

import com.mot.onlineshop.payment.domain.models.payment.Payment;
import com.mot.onlineshop.payment.domain.ports.clients.ApiClient;
import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.*;
import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.transaction.*;
import com.mot.onlineshop.payment.infrastructure.transversal.exceptions.TechnicalException;
import com.mot.onlineshop.payment.infrastructure.adapters.models.converters.ModelConverter;
import com.mot.onlineshop.payment.infrastructure.adapters.models.shared.Config;
import com.mot.onlineshop.payment.infrastructure.adapters.models.shared.Payload;
import com.mot.onlineshop.payment.infrastructure.adapters.models.shared.orderms.Order;
import com.mot.onlineshop.payment.infrastructure.adapters.models.shared.userms.Person;
import com.mot.onlineshop.payment.infrastructure.adapters.persistence.memory.InMemoryPersistence;
import com.mot.onlineshop.payment.domain.ports.clients.PaymentProvider;
import com.mot.onlineshop.payment.infrastructure.transversal.constants.PaymentConstants;
import com.mot.onlineshop.payment.infrastructure.transversal.transform.PaymentTransform;
import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.merchant.Merchant;
import com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.payer.Payer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component @AllArgsConstructor @NoArgsConstructor
public class PaymentProviderImp implements PaymentProvider {

    @Autowired
    private InMemoryPersistence inMemoryPersistence;

    @Autowired
    private ApiClient<PayUResponse, PayURequest> apiClient;

    @Autowired
    private ModelConverter modelConverter;

    //private PaymentTransform paymentTransform = new PaymentTransform();

    private static Logger log = LogManager.getLogger(PaymentProviderImp.class);

    @Override
    public Payment postPaymentProvider(Payment payment) {
        String methodSignature = PaymentConstants.INITIALIZATION_METHOD + " getPaymentProvider";
        log.info(methodSignature);
        PaymentTransform paymentTransform = new PaymentTransform();
        Order order = inMemoryPersistence.getOrder(payment.getOrderReference());
        Person person = inMemoryPersistence.getPerson(order.getDniNumber());
        CreditCard creditCard = inMemoryPersistence.getCreditCard("4037997623271984");
        PayUOrder payUOrder = modelConverter.converter(order);
        Config config = inMemoryPersistence.getConfig("PayU");
        payUOrder.setAccountId(config.getAccountId());
        payUOrder.setLanguage(config.getLanguage());
        payUOrder.setNotifyUrl(config.getNotifyUrl());
        payUOrder.setDescription(payment.getDescription());
        payUOrder.setReferenceCode(payment.getPaymentReference().getId().toString() + payment.getDatetimePayment().toString());
        log.debug("ReferenceCode:" + payUOrder.getReferenceCode());
        Merchant merchant = new Merchant(config.getApiKey(), config.getApiLogin());
        Payer payer = modelConverter.converter(person);
        Transaction transaction = new Transaction(payUOrder, payer, creditCard, PaymentConstants.TRANSACTION_TYPE_AUTH_AND_CAPT, "VISA", payment.getPaymentCountry());
        String signature = config.getApiKey() + "~" + config.getMerchantId() + "~" + payUOrder.getReferenceCode() + "~" + payUOrder.getAdditionalValues().getTX_VALUE().getValue() + "~" + payUOrder.getAdditionalValues().getTX_VALUE().getCurrency();
        log.debug("signature:" + signature);
        String signatureMD5 = null;
        String algorithm="MD5";
        try {

            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(signature.getBytes());
            byte[] digest = md.digest();
            signatureMD5 = DatatypeConverter
                    .printHexBinary(digest).toLowerCase();
        } catch (NoSuchAlgorithmException ex) {
            throw new TechnicalException("T-501",algorithm);
        }
        log.debug("MD5_Hash:" + signatureMD5);
        payUOrder.setSignature(signatureMD5);
        PayURequestPayment payURequestPayment = new PayURequestPayment();
        payURequestPayment.setLanguage(PaymentConstants.LANGUAGE_ES);
        payURequestPayment.setCommand(PaymentConstants.COMMAND_SUBMIT_TRANSACTION);
        payURequestPayment.setMerchant(merchant);
        payURequestPayment.setTransaction(transaction);
        payURequestPayment.setTest(true);
        PayUResponse response = new PayUResponse();
        String jsonResponse = null;

        Payload payload = (Payload) paymentTransform.transformPaymentStringToObject(payment.getPayload(),new Payload());
        if(payload.getProvider().equals(PaymentConstants.PAYMENT_PROVIDER_PAYU))
        {
            try {
                response = apiClient.post(payURequestPayment, PaymentConstants.TRANSACTION_IN_PROCESS_PAYMENT);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String jsonRequest = paymentTransform.transformPaymentObjectToString(payURequestPayment);
            jsonResponse = paymentTransform.transformPaymentObjectToString(response);
            payment.setRequestMessage(jsonRequest);
            payment.setResponseMessage(jsonResponse);

            // log.debug("RequestMessage:"+payment.getRequestMessage());
            log.debug("ResponseMessage:" + payment.getResponseMessage());
            Payload payload1 = null;
            if (response != null ) {
                if(response.getTransactionResponse() != null){
                    payload1 = new Payload(
                            response.getTransactionResponse().getTransactionId(),
                            response.getTransactionResponse().getOrderId(),
                            response.getTransactionResponse().getState(),
                            PaymentConstants.PAYMENT_PROVIDER_PAYU
                    );

                    switch (response.getTransactionResponse().getState()) {
                        case PaymentConstants.TRANSACTION_APPROVED:
                            payment.setStatus(Payment.Status.APPROVED);
                            break;
                        default:
                            payment.setStatus(Payment.Status.DECLINED);
                            break;
                    }
                }
            }
            payment.setPayload(paymentTransform.transformPaymentObjectToString(payload1));
        }
        return payment;
    }

    @Override
    public Payment refundPayment(Payment payment) {
        String methodSignature = PaymentConstants.INITIALIZATION_METHOD + " refundPayment";
        log.info(methodSignature);
        PaymentTransform paymentTransform = new PaymentTransform();
        Config config = inMemoryPersistence.getConfig("PayU");
        Merchant merchant = new Merchant(config.getApiKey(), config.getApiLogin());
        Payload payload = (Payload) paymentTransform.transformPaymentStringToObject(payment.getPayload(), new Payload());
        TransactionRefund transactionRefund = new TransactionRefund();
        transactionRefund.setParentTransactionId(payload.getTransactionId());
        transactionRefund.setOrder(new OrderId(payload.getOrderId()));
        transactionRefund.setType(PaymentConstants.TRANSACTION_TYPE_VOID);
        transactionRefund.setReason(payment.getDescription());
        PayURequestRefund payURequestRefund = new PayURequestRefund();
        payURequestRefund.setLanguage(PaymentConstants.LANGUAGE_ES);
        payURequestRefund.setMerchant(merchant);
        payURequestRefund.setTransaction(transactionRefund);
        payURequestRefund.setCommand(PaymentConstants.COMMAND_SUBMIT_TRANSACTION);
        payURequestRefund.setTest(false);
        PayUResponse response = new PayUResponse();
        String jsonResponse = null;
        if(payload.getProvider().equals(PaymentConstants.PAYMENT_PROVIDER_PAYU)) {
            try {
                response = apiClient.post(payURequestRefund, PaymentConstants.TRANSACTION_IN_PROCESS_REFUND);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String jsonRequest = paymentTransform.transformPaymentObjectToString(payURequestRefund);
            jsonResponse = paymentTransform.transformPaymentObjectToString(response);
            payment.setRequestMessage(jsonRequest);
            payment.setResponseMessage(jsonResponse);

            switch (response.getCode()) {
                case PaymentConstants.TRANSACTION_CODE_SUCCESS:
                    payment.setStatus(Payment.Status.REFUND);
                    break;
                default:
                    payment.setStatus(Payment.Status.DECLINED);
                    payload = (Payload) paymentTransform.transformPaymentStringToObject(payment.getPayload(), new Payload());
                    payload.setStatus(Payment.Status.DECLINED.toString());
                    payment.setPayload(paymentTransform.transformPaymentObjectToString(payload));
                    break;
            }
        }
        return payment;
    }
}
