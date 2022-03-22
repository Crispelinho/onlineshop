package com.mot.onlineshop.payment.domain.exceptions;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class ExceptionsConstants {
    public static final String PAYMENT_METHOD_NULL = "Payment Method is required";
    public static final String PAYMENT_VALUE_NULL = "Payment Value is required";
    public static final String ORDER_REFERENCE_NULL = "Order References is required";
    public static final String PAYMENT_REFERENCE_NULL = "Payment Reference is required";
    public static final String INVALID_PAYMENT_METHOD = "Invalid Payment Method";
    public static final String INVALID_PAYMENT_VALUE = "Invalid Payment Value";
    public static final String INVALID_ORDER_REFERENCE = "Invalid Order Reference";
    public static final String PAYMENT_NOT_FOUND = "Payment not found";
    public static final String INVALID_PAYMENT_REFERENCE = "Invalid Payment Reference";
    public static final String TRANSACTION_NOT_PROCESSED = "Transaction can not be processed because the payment status is declined";

    private String message;
    private String param;
    public ExceptionsConstants(String code, String param){
        this.message = this.HandlerStatusErrorCode(code,param);
        System.out.println(message);
    }
    public String HandlerStatusErrorCode(String code,String param){
        switch (code){
            case "R-401":
                return PAYMENT_METHOD_NULL;
            case "R-402":
                return PAYMENT_VALUE_NULL;
            case "R-403":
                return ORDER_REFERENCE_NULL;
            case "R-404":
                return PAYMENT_REFERENCE_NULL;
            case "B-301":
                return INVALID_PAYMENT_METHOD;
            case "B-302":
                return INVALID_PAYMENT_VALUE;
            case "B-303":
                return INVALID_ORDER_REFERENCE;
            case "B-304":
                return PAYMENT_NOT_FOUND+":["+param+"]";
            case "B-305":
                return INVALID_PAYMENT_REFERENCE;
            case "B-306":
                return TRANSACTION_NOT_PROCESSED+":["+param+"]";
        }
        return code;
    }

}
