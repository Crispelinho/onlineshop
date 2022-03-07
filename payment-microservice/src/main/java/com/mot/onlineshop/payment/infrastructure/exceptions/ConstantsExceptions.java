package com.mot.onlineshop.payment.infrastructure.exceptions;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class ConstantsExceptions {
    public static final String PAYMENT_METHOD_NULL = "Payment Method is required";
    public static final String PAYMENT_VALUE_NULL = "Payment Value is required";
    public static final String ORDER_REFERENCE_NULL = "Order References is required";

    private String code;
    private String message;
    public ConstantsExceptions(String code){
        this.message = this.HandlerStatusErrorCode(code);
    }
    public String HandlerStatusErrorCode(String code){
        switch (code){
            case "P-401":
                return PAYMENT_METHOD_NULL;
            case "P-402":
                return PAYMENT_VALUE_NULL;
            case "P-403":
                return ORDER_REFERENCE_NULL;
        }
        return code;
    }

}
