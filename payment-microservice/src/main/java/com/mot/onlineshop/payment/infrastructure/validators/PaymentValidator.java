package com.mot.onlineshop.payment.infrastructure.validators;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.infrastructure.exceptions.BusinessException;
import com.mot.onlineshop.payment.infrastructure.exceptions.RequestException;
import com.mot.onlineshop.payment.infrastructure.rest.DTO.PaymentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.regex.Pattern;

@Data @Builder @AllArgsConstructor
public class PaymentValidator {
    private PaymentDTO paymentDTO;
    private Boolean statusValidator;

    public void validationOfPaymentMethod(){
        if (paymentDTO.getPaymentMethod()==null || paymentDTO.getPaymentMethod().isEmpty()){
            throw new RequestException("P-401");
        }
        try{
            Payment.PaymentMethod paymentMethod = Payment.PaymentMethod.valueOf(paymentDTO.getPaymentMethod());

        }catch (IllegalArgumentException ex){
            throw new BusinessException("P-301", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        statusValidator = Boolean.TRUE;
    }

    public void validationOfPaymentValue(){
        if(paymentDTO.getPaymentValue()==null){
            throw new RequestException("P-402");
        }
        if(paymentDTO.getPaymentValue().isNaN() || paymentDTO.getPaymentValue() <= 0){
            throw new BusinessException("P-302", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        statusValidator = Boolean.TRUE;
    }

    public void validationOfOrderReference(){
        if(paymentDTO.getOrderReference() == null || paymentDTO.getOrderReference().isEmpty()){
            throw new RequestException("P-403");
        }
        Pattern p = Pattern.compile("^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{4}-[89ab][0-9a-f]{4}-[0-9a-f]{12}$");
        if( p.matcher(paymentDTO.getOrderReference()).matches() || paymentDTO.getOrderReference().isEmpty()){
            throw new BusinessException("P-303", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        statusValidator = Boolean.TRUE;
    }

    public boolean initValidation(){
        validationOfPaymentMethod();
        validationOfPaymentValue();
        validationOfOrderReference();
        return statusValidator;
    }

}
