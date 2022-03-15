package com.mot.onlineshop.payment.infrastructure.rest.transform;

import com.google.gson.Gson;
import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.domain.models.PaymentId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.UUID;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class PaymentTransform {
    private Payment payment;

    private static Logger log = LogManager.getLogger(PaymentTransform.class);

    public PaymentId transformPaymentReference(String paymentReference){
        String methodSignature = "Inicializando método transformPaymentReference";
        log.debug(methodSignature);
        if (payment == null) payment = new Payment();
        if (paymentReference != null) {
            UUID paymentIdUuid = UUID.fromString(paymentReference);
            if(payment.getPaymentReference()!=null) payment.getPaymentReference().setId(paymentIdUuid);
        }
        return payment.getPaymentReference();
    }

    public Payment.PaymentMethod transformPaymentMethod(String paymentMethod){
        String methodSignature = "Inicializando método transformPaymentMethod";
        log.debug(methodSignature);
        try {
            return Payment.PaymentMethod.valueOf(paymentMethod);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public LocalDateTime transformDateTime(String dateTime){
        String methodSignature = "Inicializando método transformDateTime";
        log.debug(methodSignature);
        LocalDateTime localDateTime = null;
        if(dateTime != null) localDateTime = LocalDateTime.parse(dateTime);
        return localDateTime;
    }

    public String transformPaymentObjectToString(Object object){
        String methodSignature = "Inicializando método transformPaymentObjectToString";
        log.debug(methodSignature);
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    public Object transformPaymentStringToObject(String jsonString, Object object){
        String methodSignature = "Inicializando método transformPaymentStringToObject";
        log.debug(methodSignature);
        Gson gson = new Gson();
        return gson.fromJson(jsonString, object.getClass());
    }
}
