package com.mot.onlineshop.payment.infrastructure.rest.api.validators;

import com.mot.onlineshop.payment.domain.models.payment.Payment;
import com.mot.onlineshop.payment.domain.exceptions.BusinessException;
import com.mot.onlineshop.payment.infrastructure.constants.PaymentConstants;
import com.mot.onlineshop.payment.infrastructure.exceptions.RequestException;
import com.mot.onlineshop.payment.infrastructure.rest.api.DTOs.PaymentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;

import java.util.regex.Pattern;

@Data @Builder @AllArgsConstructor
public class PaymentValidator {
    private PaymentDTO paymentDTO;
    private Boolean statusValidator;

    private static final Logger log = LogManager.getLogger(PaymentValidator.class);

    public void validationOfPaymentMethod(){
        String methodSignature = "Inicializando método validationOfPaymentMethod";
        log.debug(methodSignature);
        if (paymentDTO.getPaymentMethod()==null || paymentDTO.getPaymentMethod().isEmpty()){
            throw new RequestException("R-401");
        }
        try{
            Payment.PaymentMethod paymentMethod = Payment.PaymentMethod.valueOf(paymentDTO.getPaymentMethod());

        }catch (IllegalArgumentException ex){
            throw new BusinessException("B-301", null,HttpStatus.BAD_REQUEST);
        }
        statusValidator = Boolean.TRUE;
    }

    public void validationOfPaymentValue(){
        String methodSignature = "Inicializando método validationOfPaymentValue";
        log.debug(methodSignature);
        if(paymentDTO.getPaymentValue()==null){
            throw new RequestException("R-402");
        }
        if(paymentDTO.getPaymentValue().isNaN() || paymentDTO.getPaymentValue() <= 0){
            throw new BusinessException("B-302",null, HttpStatus.BAD_REQUEST);
        }
        statusValidator = Boolean.TRUE;
    }

    public void validationOfOrderReference(){
        String methodSignature = "Inicializando método validationOfOrderReference";
        log.debug(methodSignature);
        if(paymentDTO.getOrderReference() == null || paymentDTO.getOrderReference().isEmpty()){
            throw new RequestException("R-403");
        }
        log.info("validationOfOrderReference->"+paymentDTO.getOrderReference());
        Pattern p = Pattern.compile(PaymentConstants.UUID_REFERENCE_VALIDATION_PATTERN);
        if( !p.matcher(paymentDTO.getOrderReference()).matches() || paymentDTO.getOrderReference().isEmpty()){
            throw new BusinessException("B-303", null,HttpStatus.BAD_REQUEST);
        }
        statusValidator = Boolean.TRUE;
    }

    public void validationOfPaymentReference(String paymentReference){
        String methodSignature = "Inicializando método validationOfPaymentReference";
        log.debug(methodSignature);
        if(paymentReference == null || paymentReference.isEmpty()){
            throw new RequestException("R-404");
        }
        Pattern p = Pattern.compile(PaymentConstants.UUID_REFERENCE_VALIDATION_PATTERN);
        if( !p.matcher(paymentReference).matches() || paymentReference.isEmpty()){
            throw new BusinessException("B-305", null,HttpStatus.BAD_REQUEST);
        }
        statusValidator = Boolean.TRUE;
    }

    public void paymentValidationNotFound(){
        if (paymentDTO == null || paymentDTO.getPaymentReference() == null){
            throw new BusinessException("B-304",paymentDTO.getPaymentReference(),HttpStatus.BAD_REQUEST);
        }
        statusValidator = Boolean.TRUE;
    }

    public boolean initValidation(){
        String methodSignature = "Inicializando método initValidation";
        log.debug(methodSignature);
        validationOfPaymentMethod();
        validationOfPaymentValue();
        validationOfOrderReference();
        return statusValidator;
    }

}
