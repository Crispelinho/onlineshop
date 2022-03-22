package com.mot.onlineshop.payment.infrastructure.adapters.models.providers.PayU.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
public class AdditionalValues implements Serializable {
    TX TX_VALUE;
    TX TX_TAX;
    TX TX_TAX_RETURN_BASE;
}
