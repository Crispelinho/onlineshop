package com.mot.onlineshop.payment.infrastructure.ports.rest.api.controllers;

import com.mot.onlineshop.payment.domain.exceptions.InvalidPaymentException;
import com.mot.onlineshop.payment.domain.exceptions.PaymentNotFoundException;
import com.mot.onlineshop.payment.domain.exceptions.BusinessException;
import com.mot.onlineshop.payment.domain.exceptions.constants.ExceptionsConstants;
import com.mot.onlineshop.payment.infrastructure.ports.rest.api.DTOs.ErrorDTO;
import com.mot.onlineshop.payment.infrastructure.transversal.exceptions.RequestException;
import com.mot.onlineshop.payment.infrastructure.ports.rest.api.DTOs.FieldErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorDTO> runtimeExceptionHandler(RuntimeException ex){
        ErrorDTO errorDTO = ErrorDTO.builder().code("P-500").message(ex.getMessage()).build();
        System.err.println("Error:"+ex.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<ErrorDTO> requestExceptionHandler(RequestException ex){
        ErrorDTO errorDTO = ErrorDTO.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ErrorDTO> businessExceptionHandler(BusinessException ex){
        ErrorDTO errorDTO = ErrorDTO.builder().code(ex.getCode()).message(ex.getMessage()).build();
        System.out.println(ex.getStackTrace());
        return new ResponseEntity<>(errorDTO, ex.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        FieldErrorDTO fieldErrorDTO = new FieldErrorDTO();
        fieldErrorDTO.setCode("R-400");
        fieldErrorDTO.setMessage(ExceptionsConstants.REQUEST_NOT_VALID);
        fieldErrorDTO.setErrors(errors);
        System.out.println(fieldErrorDTO);
        return new ResponseEntity<>(fieldErrorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = PaymentNotFoundException.class)
    public ResponseEntity<ErrorDTO> paymentNotFoundException(PaymentNotFoundException ex){
        ErrorDTO errorDTO = ErrorDTO.builder().message(ex.getMessage()).build();
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = InvalidPaymentException.class)
    public ResponseEntity<ErrorDTO> invalidPaymentException(InvalidPaymentException ex){
        ErrorDTO errorDTO = ErrorDTO.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
