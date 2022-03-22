package com.mot.onlineshop.payment.infrastructure.rest.api.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ErrorDTO {
    private String code;
    private String message;

    public static ErrorDTOBuilder builder() {
        return new ErrorDTOBuilder();
    }

    public static class ErrorDTOBuilder {
        private String code;
        private String message;

        ErrorDTOBuilder() {
        }

        public ErrorDTOBuilder code(String code) {
            this.code = code;
            return this;
        }

        public ErrorDTOBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ErrorDTO build() {
            return new ErrorDTO(code, message);
        }

        public String toString() {
            return "ErrorDTO.ErrorDTOBuilder(code=" + this.code + ", message=" + this.message + ")";
        }
    }
}
