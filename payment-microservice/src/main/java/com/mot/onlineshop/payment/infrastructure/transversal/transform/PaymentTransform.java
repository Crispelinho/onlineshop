package com.mot.onlineshop.payment.infrastructure.transversal.transform;

import com.google.gson.Gson;
import com.mot.onlineshop.payment.domain.exceptions.BusinessException;
import com.mot.onlineshop.payment.domain.models.payment.Payment;
import com.mot.onlineshop.payment.domain.models.payment.PaymentId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class PaymentTransform {
    private Payment payment;

    private static Logger log = LogManager.getLogger(PaymentTransform.class);

    public PaymentId transformPaymentReference(String paymentReference){
        String methodSignature = "Initialization method transformPaymentReference";
        log.debug(methodSignature);
        if (payment == null) payment = new Payment();
        if (paymentReference != null) {
            UUID paymentIdUuid = UUID.fromString(paymentReference);
            if(payment.getPaymentReference()!=null) payment.getPaymentReference().setId(paymentIdUuid);
        }
        return payment.getPaymentReference();
    }

    public Payment.PaymentMethod transformPaymentMethod(String paymentMethod){
        String methodSignature = "Initialization method transformPaymentMethod";
        log.debug(methodSignature);
        try {
            return Payment.PaymentMethod.valueOf(paymentMethod);
        } catch (Exception e) {
            throw new BusinessException("B-301", null, HttpStatus.BAD_REQUEST);
        }
    }

    public LocalDateTime transformDateTime(String dateTime){
        String methodSignature = "Initialization method transformDateTime";
        log.debug(methodSignature);
        LocalDateTime localDateTime = null;
        if(dateTime != null) localDateTime = LocalDateTime.parse(dateTime);
        return localDateTime;
    }

    public String transformPaymentObjectToString(Object object){
        String methodSignature = "Initialization method transformPaymentObjectToString";
        log.debug(methodSignature);
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    public Object transformPaymentStringToObject(String jsonString, Object object){
        String methodSignature = "Initialization method transformPaymentStringToObject";
        log.debug(methodSignature);
        Gson gson = new Gson();
        return gson.fromJson(jsonString, object.getClass());
    }
}
