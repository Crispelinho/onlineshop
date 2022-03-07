package com.mot.onlineshop.payment.infrastructure.rest.controllers;

import com.mot.onlineshop.payment.application.command.CreatePaymentCommand;
import com.mot.onlineshop.payment.application.commandbus.Command;
import com.mot.onlineshop.payment.application.commandbus.CommandBus;
import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.domain.ports.clients.ApiClient;
import com.mot.onlineshop.payment.infrastructure.rest.DTO.PaymentDTO;
import com.mot.onlineshop.payment.infrastructure.rest.constants.PaymentConstants;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

class PaymentControllerTest {

    @Mock
    private CommandBus commandBus;

    @Mock
    private CreatePaymentCommand command;

    @InjectMocks
    private PaymentController paymentController;

    private PaymentDTO paymentDTOController;

    private PaymentDTO paymentDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Payment payment = new Payment("TC",23.0,null,null,"a4518c77-8884-4af9-bcf1-15d1bcf07b90");
        paymentDTOController = new PaymentDTO();
        paymentDTOController.setPaymentValue(23.0);
        paymentDTOController.setPaymentMethod("TC");
        paymentDTOController.setOrderReference("a4518c77-8884-4af9-bcf1-15d1bcf07b90");
        System.out.println("Create paymentDTOController");
        payment.setRequestMessage(PaymentConstants.PAYMENTREQUEST);
        payment.setResponseMessage(PaymentConstants.PAYMENTRESPONSE);
        paymentDTO = new PaymentDTO(payment);
        System.out.println("Create PaymentDTO");
        System.out.println("Finaliza setUp");
    }

    @Test
    void createPayment() throws Exception {
      ResponseEntity<PaymentDTO> response = paymentController.createPayment(paymentDTOController);
      assertNotNull(paymentController.createPayment(paymentDTOController));
      assertEquals(HttpStatus.OK, response.getStatusCode());
      //assertEquals(paymentDTO.getRequestMessage(),response.getBody().getRequestMessage());
      //assertEquals(paymentDTO.getResponseMessage(),response.getBody().getResponseMessage());
      // when(paymentController.createPayment(paymentDTOController)).thenReturn(paymentDTOResponseEntity);
      //
    }
}