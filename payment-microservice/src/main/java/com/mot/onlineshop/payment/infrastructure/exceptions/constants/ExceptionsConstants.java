package com.mot.onlineshop.payment.infrastructure.exceptions.constants;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class ExceptionsConstants {
    public static final String PAYMENT_METHOD_NULL = "Payment Method is required";
    public static final String PAYMENT_VALUE_NULL = "Payment Value is required";
    public static final String ORDER_REFERENCE_NULL = "Order References is required";
    public static final String INVALID_PAYMENT_METHOD = "Invalid Payment Method";
    public static final String INVALID_PAYMENT_VALUE = "Invalid Payment Value";
    public static final String INVALID_ORDER_REFERENCE = "Invalid Order Reference";
    public static final String PAYMENT_NOT_FOUND = "Payment not found";

    private String message;
    public ExceptionsConstants(String code){
        this.message = this.HandlerStatusErrorCode(code);
        System.out.println(message);
    }
    public String HandlerStatusErrorCode(String code){
        switch (code){
            case "P-401":
                return PAYMENT_METHOD_NULL;
            case "P-402":
                return PAYMENT_VALUE_NULL;
            case "P-403":
                return ORDER_REFERENCE_NULL;
            case "P-301":
                return INVALID_PAYMENT_METHOD;
            case "P-302":
                return INVALID_PAYMENT_VALUE;
            case "P-303":
                return INVALID_ORDER_REFERENCE;
            case "P-304":
                return PAYMENT_NOT_FOUND;
        }
        return code;
    }

}
