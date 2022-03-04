package com.mot.onlineshop.payment.infrastructure.rest.controllers;

import com.mot.onlineshop.payment.application.commandbus.CommandBus;
import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.domain.ports.clients.ApiClient;
import com.mot.onlineshop.payment.infrastructure.rest.DTO.PaymentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

class PaymentControllerTest {

    @Mock
    private CommandBus commandBus;

    @InjectMocks
    private PaymentController paymentController;

    private ResponseEntity<PaymentDTO> paymentDTOResponseEntity;

    private PaymentDTO paymentDTOController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Payment payment = new Payment("TC",23.0,null,"a4518c77-8884-4af9-bcf1-15d1bcf07b90");
        paymentDTOController = new PaymentDTO();
        paymentDTOController.setPaymentValue(23.0);
        paymentDTOController.setPaymentMethod("TC");
        paymentDTOController.setOrderReference("a4518c77-8884-4af9-bcf1-15d1bcf07b90");
        System.out.println("Create paymentDTOController");
        payment.setRequestMessage("{\n" +
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
                "    }");
        payment.setResponseMessage("{\n" +
                "        \"code\": \"SUCCESS\",\n" +
                "        \"error\": null,\n" +
                "        \"transactionResponse\": {\n" +
                "            \"orderId\": \"1403316208\",\n" +
                "            \"transactionId\": \"0fbf834e-3509-4ae7-b329-2eeafef3f4b7\",\n" +
                "            \"state\": \"APPROVED\",\n" +
                "            \"paymentNetworkResponseCode\": \"80\",\n" +
                "            \"paymentNetworkResponseErrorMessage\": null\n" +
                "        }\n" +
                "    }");
        PaymentDTO paymentDTO = new PaymentDTO(payment);
        System.out.println("Create PaymentDTO");
        paymentDTOResponseEntity = ResponseEntity.ok(paymentDTO);
        System.out.println("Finaliza setUp");
    }

    @Test
    void createPayment() throws Exception {
      // when(paymentController.createPayment(paymentDTOController)).thenReturn(paymentDTOResponseEntity);
      // assertNotNull(paymentController.createPayment(paymentDTOController));
    }
}