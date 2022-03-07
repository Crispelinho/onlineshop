package com.mot.onlineshop.payment.infrastructure.rest.constants;

public class PaymentConstants {

    public static final String PAYU_URL = "https://sandbox.api.payulatam.com/";

    public static final String PAYMENTREQUEST = "{" +
            "\"language\":\"es\"," +
            "\"command\":\"SUBMIT_TRANSACTION\"," +
            "\"merchant\":{" +
            "\"apiKey\":\"4Vj8eK4rloUd272L48hsrarnUA\"," +
            "\"apiLogin\":\"pRRXKOl8ikMmt9u\"" +
            "}," +
            "\"transaction\":{" +
            "\"order\":{" +
            "\"accountId\":\"512321\"," +
            "\"additionalValues\":{" +
            "\"tx_TAX_RETURN_BASE\":{" +
            "\"value\":54622," +
            "\"currency\":\"COP\"" +
            "}," +
            "\"tx_TAX\":{" +
            "\"value\":10378," +
            "\"currency\":\"COP\"" +
            "}," +
            "\"tx_VALUE\":{" +
            "\"value\":65000," +
            "\"currency\":\"COP\"" +
            "}" +
            "}," +
            "\"buyer\":{" +
            "\"merchantBuyerId\":\"1\"," +
            "\"fullName\":\"Firstnameandsecondbuyername\"," +
            "\"emailAddress\":\"buyer_test@test.com\"," +
            "\"contactPhone\":\"7563126\"," +
            "\"dniNumber\":\"123456789\"," +
            "\"shippingAddress\":{" +
            "\"street1\":\"Cr23No.53-50\"," +
            "\"street2\":\"5555487\"," +
            "\"city\":\"Bogotá\"," +
            "\"state\":\"BogotáD.C.\"," +
            "\"country\":\"CO\"," +
            "\"postalCode\":\"000000\"," +
            "\"phone\":\"7563126\"" +
            "}" +
            "}," +
            "\"description\":\"Paymenttestdescription\"," +
            "\"language\":\"es\"," +
            "\"notifyUrl\":\"http://www.payu.com/notify\"," +
            "\"referenceCode\":\"PRODUCT_TEST_2021-06-23T19:59:43.229Z\"," +
            "\"shippingAddress\":{" +
            "\"street1\":\"Cr23No.53-50\"," +
            "\"street2\":\"5555487\"," +
            "\"city\":\"Bogotá\"," +
            "\"state\":\"BogotáD.C.\"," +
            "\"country\":\"CO\"," +
            "\"postalCode\":\"0000000\"," +
            "\"phone\":\"7563126\"" +
            "}," +
            "\"signature\":\"1d6c33aed575c4974ad5c0be7c6a1c87\"" +
            "}," +
            "\"payer\":{" +
            "\"merchantPayerId\":\"1\"," +
            "\"fullName\":\"Firstnameandsecondpayername\"," +
            "\"emailAddress\":\"payer_test@test.com\"," +
            "\"contactPhone\":\"7563126\"," +
            "\"dniNumber\":null," +
            "\"billingAddress\":{" +
            "\"street1\":\"Cr23No.53-50\"," +
            "\"street2\":\"125544\"," +
            "\"city\":\"Bogotá\"," +
            "\"state\":\"BogotáD.C.\"," +
            "\"country\":\"CO\"," +
            "\"postalCode\":\"000000\"," +
            "\"phone\":\"7563126\"" +
            "}," +
            "\"type\":null," +
            "\"paymentMethod\":null," +
            "\"paymentCountry\":null" +
            "}," +
            "\"creditCard\":{" +
            "\"number\":\"4037997623271984\"," +
            "\"securityCode\":\"321\"," +
            "\"expirationDate\":\"2030/12\"," +
            "\"name\":\"APPROVED\"" +
            "}," +
            "\"type\":\"AUTHORIZATION_AND_CAPTURE\"," +
            "\"paymentMethod\":\"VISA\"," +
            "\"paymentCountry\":\"CO\"" +
            "}," +
            "\"test\":true" +
            "}";

    public static final String PAYMENTRESPONSE = "{" +
            "\"code\":\"SUCCESS\"," +
            "\"error\":null," +
            "\"transactionResponse\":{" +
            "\"orderId\":\"1403348329\"," +
            "\"transactionId\":\"accacbe9-cce4-4731-b060-59b61205081e\"," +
            "\"state\":\"APPROVED\"," +
            "\"paymentNetworkResponseCode\":\"08\"," +
            "\"paymentNetworkResponseErrorMessage\":null" +
            "}" +
            "}";
};
