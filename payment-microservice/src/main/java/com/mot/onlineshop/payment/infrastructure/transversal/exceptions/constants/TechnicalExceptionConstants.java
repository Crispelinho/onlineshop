package com.mot.onlineshop.payment.infrastructure.transversal.exceptions.constants;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TechnicalExceptionConstants {
    public static final String SIGNATURE_ENCRYPTION_FAILURE = "Signature encryption failure with %s algorithm:";
    public static final String HANDLER_NOT_FOUND = "No handler for class: %s";

    private String message;
    private String param;
    public TechnicalExceptionConstants(String code, String param){
        this.message = this.HandlerStatusErrorCode(code,param);
        System.out.println(message);
    }
    public String HandlerStatusErrorCode(String code,String param){
        switch (code){
            case "T-501":
                return String.format(SIGNATURE_ENCRYPTION_FAILURE,param);
            case "T-502":
                return String.format(HANDLER_NOT_FOUND, param);
        }
        return code;
    }
}
