package com.mot.onlineshop.payment.infrastructure.rest.api.DTOs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {
    private String code;
    private String message;
}
