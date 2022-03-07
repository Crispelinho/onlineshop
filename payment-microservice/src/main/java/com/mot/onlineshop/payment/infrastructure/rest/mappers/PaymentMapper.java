package com.mot.onlineshop.payment.infrastructure.rest.mappers;

import com.google.gson.Gson;
import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.domain.models.PaymentId;
import com.mot.onlineshop.payment.infrastructure.persistence.entities.PaymentEntity;
import com.mot.onlineshop.payment.infrastructure.rest.DTO.PaymentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class PaymentMapper {
    private Payment payment;

    private static Logger log = LogManager.getLogger(PaymentMapper.class);

    public PaymentId transformPaymentReference(String paymentReference){
        String methodSignature = "Inicializando método transformPaymentReference";
        log.debug(methodSignature);
        UUID paymentIdUuid = UUID.fromString(paymentReference);
        this.payment.getPaymentReference().setId(paymentIdUuid);
        return this.payment.getPaymentReference();
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
      //  log.info("json:"+jsonString);
      //  log.info("object:"+object);
        return gson.fromJson(jsonString, object.getClass());
    }

    public PaymentEntity convertToEntity(){
        String methodSignature = "Inicializando método convertToEntity";
        log.debug(methodSignature);
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setPaymentReference(payment.getPaymentReference().getId().toString());
        paymentEntity.setPaymentValue(payment.getPaymentValue());
        paymentEntity.setPaymentMethod(payment.getPaymentMethod());
        paymentEntity.setDatetimePayment(payment.getDatetimePayment());
        paymentEntity.setRequestMessage(null);
        paymentEntity.setResponseMessage(payment.getResponseMessage());
        paymentEntity.setOrderReference(payment.getOrderReference());
        return paymentEntity;
    }

    public Payment converToModel(PaymentEntity paymentEntity){
        String methodSignature = "Inicializando método converToModel";
        log.debug(methodSignature);
        Payment payment = new Payment();
        log.info("getPaymentReference:"+paymentEntity.getPaymentReference());
        payment.getPaymentReference().setId(UUID.fromString(paymentEntity.getPaymentReference()));
        payment.setPaymentValue(paymentEntity.getPaymentValue());
        payment.setPaymentMethod(paymentEntity.getPaymentMethod());
        payment.setDatetimePayment(paymentEntity.getDatetimePayment());
        payment.setRequestMessage(paymentEntity.getRequestMessage());
        payment.setResponseMessage(paymentEntity.getResponseMessage());
        payment.setOrderReference(paymentEntity.getOrderReference());
        return payment;
    }

    public Payment convertToModel(PaymentDTO paymentDTO){
        String methodSignature = "Inicializando método converToModel";
        log.debug(methodSignature);
        log.info(paymentDTO.getRequestMessage());
        return this.payment = new Payment(
                paymentDTO.getPaymentMethod(),
                paymentDTO.getPaymentValue(),
                null,
                null,
                paymentDTO.getOrderReference());
    }
}
