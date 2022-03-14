package com.mot.onlineshop.payment.infrastructure.rest.controllers;

import com.mot.onlineshop.payment.application.command.CreatePaymentCommand;
import com.mot.onlineshop.payment.application.commandbus.CommandBus;
import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.infrastructure.rest.DTO.CreatePaymentDTO;

import com.mot.onlineshop.payment.infrastructure.rest.mappers.CreatePaymentMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PaymentControllerTest {

    @Mock
    private CommandBus commandBus;

    @InjectMocks
    private PaymentController paymentController;

    private CreatePaymentDTO paymentDTOController;

    private CreatePaymentCommand createPaymentCommand;

    private CreatePaymentMapper createPaymentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        paymentDTOController = new CreatePaymentDTO();
        paymentDTOController.setPaymentValue(23.0);
        paymentDTOController.setPaymentMethod("TC");
        paymentDTOController.setOrderReference("a4518c77-8884-4af9-bcf1-15d1bcf07b90");
        System.out.println("Create paymentDTOController");
        Payment payment = createPaymentMapper.paymentDtoToPayment(paymentDTOController);
        createPaymentCommand = new CreatePaymentCommand(payment);
        System.out.println(createPaymentCommand);
        System.out.println("Create CreatePaymentDTO");
        System.out.println(paymentDTOController);
        System.out.println("Finaliza setUp");
    }

    @Test
    void createPayment() throws Exception {
        doNothing().when(commandBus).handle(createPaymentCommand);
        //paymentDTOController.setPaymentMethod("TD");
        ResponseEntity<CreatePaymentDTO> response = paymentController.createPayment(paymentDTOController);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(commandBus,times(1)).handle(createPaymentCommand);
    }
}