package com.mot.onlineshop.payment.infrastructure.rest.constants;

public class PaymentConstants {

    public static final String PAYU_URL = "https://sandbox.api.payulatam.com/";

    public static final String PAYMENTREQUEST = "{\n" +
            "        \"language\": \"es\",\n" +
            "        \"command\": \"SUBMIT_TRANSACTION\",\n" +
            "        \"merchant\": {\n" +
            "            \"apiKey\": \"4Vj8eK4rloUd272L48hsrarnUA\",\n" +
            "            \"apiLogin\": \"pRRXKOl8ikMmt9u\"\n" +
            "        },\n" +
            "        \"transaction\": {\n" +
            "            \"order\": {\n" +
            "                \"accountId\": \"512321\",\n" +
            "                \"additionalValues\": {\n" +
            "                    \"tx_VALUE\": {\n" +
            "                        \"value\": 65000,\n" +
            "                        \"currency\": \"COP\"\n" +
            "                    },\n" +
            "                    \"tx_TAX\": {\n" +
            "                        \"value\": 10378,\n" +
            "                        \"currency\": \"COP\"\n" +
            "                    },\n" +
            "                    \"tx_TAX_RETURN_BASE\": {\n" +
            "                        \"value\": 54622,\n" +
            "                        \"currency\": \"COP\"\n" +
            "                    }\n" +
            "                },\n" +
            "                \"buyer\": {\n" +
            "                    \"merchantBuyerId\": \"1\",\n" +
            "                    \"fullName\": \"First name and second buyer name\",\n" +
            "                    \"emailAddress\": \"buyer_test@test.com\",\n" +
            "                    \"contactPhone\": \"7563126\",\n" +
            "                    \"dniNumber\": \"123456789\",\n" +
            "                    \"shippingAddress\": {\n" +
            "                        \"street1\": \"Cr 23 No. 53-50\",\n" +
            "                        \"street2\": \"5555487\",\n" +
            "                        \"city\": \"Bogotá\",\n" +
            "                        \"state\": \"Bogotá D.C.\",\n" +
            "                        \"country\": \"CO\",\n" +
            "                        \"postalCode\": \"000000\",\n" +
            "                        \"phone\": \"7563126\"\n" +
            "                    }\n" +
            "                },\n" +
            "                \"description\": \"Payment test description\",\n" +
            "                \"language\": \"es\",\n" +
            "                \"notifyUrl\": \"http://www.payu.com/notify\",\n" +
            "                \"referenceCode\": \"PRODUCT_TEST_2021-06-23T19:59:43.229Z\",\n" +
            "                \"shippingAddress\": {\n" +
            "                    \"street1\": \"Cr 23 No. 53-50\",\n" +
            "                    \"street2\": \"5555487\",\n" +
            "                    \"city\": \"Bogotá\",\n" +
            "                    \"state\": \"Bogotá D.C.\",\n" +
            "                    \"country\": \"CO\",\n" +
            "                    \"postalCode\": \"0000000\",\n" +
            "                    \"phone\": \"7563126\"\n" +
            "                },\n" +
            "                \"signature\": \"1d6c33aed575c4974ad5c0be7c6a1c87\"\n" +
            "            },\n" +
            "            \"payer\": {\n" +
            "                \"merchantPayerId\": \"1\",\n" +
            "                \"fullName\": \"First name and second payer name\",\n" +
            "                \"emailAddress\": \"payer_test@test.com\",\n" +
            "                \"contactPhone\": \"7563126\",\n" +
            "                \"dniNumber\": null,\n" +
            "                \"billingAddress\": {\n" +
            "                    \"street1\": \"Cr 23 No. 53-50\",\n" +
            "                    \"street2\": \"125544\",\n" +
            "                    \"city\": \"Bogotá\",\n" +
            "                    \"state\": \"Bogotá D.C.\",\n" +
            "                    \"country\": \"CO\",\n" +
            "                    \"postalCode\": \"000000\",\n" +
            "                    \"phone\": \"7563126\"\n" +
            "                },\n" +
            "                \"type\": null,\n" +
            "                \"paymentMethod\": null,\n" +
            "                \"paymentCountry\": null\n" +
            "            },\n" +
            "            \"creditCard\": {\n" +
            "                \"number\": \"4037997623271984\",\n" +
            "                \"securityCode\": \"321\",\n" +
            "                \"expirationDate\": \"2030/12\",\n" +
            "                \"name\": \"APPROVED\"\n" +
            "            },\n" +
            "            \"type\": \"AUTHORIZATION_AND_CAPTURE\",\n" +
            "            \"paymentMethod\": \"VISA\",\n" +
            "            \"paymentCountry\": \"CO\"\n" +
            "        },\n" +
            "        \"test\": true\n" +
            "    }";

    public static final String PAYMENTRESPONSE = "{\n" +
            "        \"code\": \"SUCCESS\",\n" +
            "        \"error\": null,\n" +
            "        \"transactionResponse\": {\n" +
            "            \"orderId\": \"1403316208\",\n" +
            "            \"transactionId\": \"0fbf834e-3509-4ae7-b329-2eeafef3f4b7\",\n" +
            "            \"state\": \"APPROVED\",\n" +
            "            \"paymentNetworkResponseCode\": \"80\",\n" +
            "            \"paymentNetworkResponseErrorMessage\": null\n" +
            "        }\n" +
            "    }";
};
