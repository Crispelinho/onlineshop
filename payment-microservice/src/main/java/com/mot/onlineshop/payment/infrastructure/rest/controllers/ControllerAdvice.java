package com.mot.onlineshop.payment.infrastructure.rest.controllers;

import com.mot.onlineshop.payment.infrastructure.exceptions.BusinessException;
import com.mot.onlineshop.payment.infrastructure.exceptions.RequestException;
import com.mot.onlineshop.payment.infrastructure.rest.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
        return new ResponseEntity<>(errorDTO, ex.getStatus());
    }
}
