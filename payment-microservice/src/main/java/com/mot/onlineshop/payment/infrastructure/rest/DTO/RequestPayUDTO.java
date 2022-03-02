package com.mot.onlineshop.payment.infrastructure.rest.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
public class RequestPayUDTO implements Serializable {

    private String language;
    private String command;
    private Merchant merchant;
    private class Merchant {
        private String apiKey;
        private String apiLogin;
    }
    private Transacction transacction;
    private class Transacction{
        private class Order{
            private String accountId;
            private String referenceCode;
            private String description;
            private String language;
            private String signature;
            private String notityUrl;
            private AdditionalValues additionalValues;
            public class AdditionalValues{

                TX TX_VALUE;
                TX TX_TAX;
                TX TX_TAX_RETURN_BASE;

                public class TX{
                    private String value;
                    private String currency;
                }
            }
        }
        private class Payer{
            private String merchantPayerId;
            private String fullName;
            private String emailAddress;
            private String contactPhone;
            private String dniNumber;
            private BillingAddress billingAddress;
            public class BillingAddress{
                private String street1;
                private String street2;
                private String city;
                private String state;
                private String country;
                private String postalCode;
                private String phone;
            }

        }
        private class creditCard{

        }
        private String type;
        private String paymentMethod;
        private String paymentCountry;
        private class ThreeDomainSecure{

        }
    }
    private boolean test;

}
