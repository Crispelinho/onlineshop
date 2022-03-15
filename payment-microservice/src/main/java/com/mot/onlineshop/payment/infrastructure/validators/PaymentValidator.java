package com.mot.onlineshop.payment.infrastructure.validators;

import com.mot.onlineshop.payment.domain.models.payment.Payment;
import com.mot.onlineshop.payment.domain.exceptions.BusinessException;
import com.mot.onlineshop.payment.infrastructure.exceptions.RequestException;
import com.mot.onlineshop.payment.infrastructure.rest.DTO.PaymentDTO;
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
            throw new RequestException("P-401");
        }
        try{
            Payment.PaymentMethod paymentMethod = Payment.PaymentMethod.valueOf(paymentDTO.getPaymentMethod());

        }catch (IllegalArgumentException ex){
            throw new BusinessException("P-301", null,HttpStatus.BAD_REQUEST);
        }
        statusValidator = Boolean.TRUE;
    }

    public void validationOfPaymentValue(){
        String methodSignature = "Inicializando método validationOfPaymentValue";
        log.debug(methodSignature);
        if(paymentDTO.getPaymentValue()==null){
            throw new RequestException("P-402");
        }
        if(paymentDTO.getPaymentValue().isNaN() || paymentDTO.getPaymentValue() <= 0){
            throw new BusinessException("P-302",null, HttpStatus.BAD_REQUEST);
        }
        statusValidator = Boolean.TRUE;
    }

    public void validationOfOrderReference(){
        String methodSignature = "Inicializando método validationOfOrderReference";
        log.debug(methodSignature);
        if(paymentDTO.getOrderReference() == null || paymentDTO.getOrderReference().isEmpty()){
            throw new RequestException("P-403");
        }
        Pattern p = Pattern.compile("^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{4}-[89ab][0-9a-f]{4}-[0-9a-f]{12}$");
        if( p.matcher(paymentDTO.getOrderReference()).matches() || paymentDTO.getOrderReference().isEmpty()){
            throw new BusinessException("P-303", null,HttpStatus.BAD_REQUEST);
        }
        statusValidator = Boolean.TRUE;
    }

    public void validationOfPaymentReference(String paymentReference){
        String methodSignature = "Inicializando método validationOfPaymentReference";
        log.debug(methodSignature);
        if(paymentReference == null || paymentReference.isEmpty()){
            throw new RequestException("P-404");
        }
        Pattern p = Pattern.compile("^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{4}-[89ab][0-9a-f]{4}-[0-9a-f]{12}$");
        if( p.matcher(paymentReference).matches() || paymentReference.isEmpty()){
            throw new BusinessException("P-305", null,HttpStatus.BAD_REQUEST);
        }
        statusValidator = Boolean.TRUE;
    }

    public void paymentValidationNotFound(){
        if (paymentDTO == null || paymentDTO.getPaymentReference() == null){
            throw new BusinessException("P-304",paymentDTO.getPaymentReference(),HttpStatus.BAD_REQUEST);
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
