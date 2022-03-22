package com.mot.onlineshop.payment.infrastructure.rest.api.DTOs;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
public class FieldErrorDTO extends ErrorDTO{
    private Map<String, String> errors = new HashMap<>();
}
