package com.mot.onlineshop.payment.infrastructure.rest.controllers;

import com.mot.onlineshop.payment.application.command.CreatePaymentCommand;
import com.mot.onlineshop.payment.application.commandbus.CommandBus;
import com.mot.onlineshop.payment.application.querybus.QueryBus;
import com.mot.onlineshop.payment.domain.models.payment.Payment;
import com.mot.onlineshop.payment.infrastructure.mappers.PaymentMapper;
import com.mot.onlineshop.payment.infrastructure.rest.api.controllers.PaymentController;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayURequest;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayUResponse;
import com.mot.onlineshop.payment.infrastructure.rest.api.DTOs.CreatePaymentDTO;

import com.mot.onlineshop.payment.infrastructure.constants.PaymentConstantsTest;
import com.mot.onlineshop.payment.infrastructure.mappers.RefundPaymentMapper;
import com.mot.onlineshop.payment.infrastructure.transform.PaymentTransform;
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
    @Mock
    private QueryBus queryBus;
    @Mock
    private PaymentMapper paymentMapper;
    @Mock
    private RefundPaymentMapper refundPaymentMapper;

    @InjectMocks
    private PaymentController paymentController;

    private CreatePaymentDTO paymentDTOController;

    private CreatePaymentCommand createPaymentCommand;

    private Payment payment;

    private PaymentTransform paymentTransform = PaymentTransform.builder().build();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        paymentDTOController = new CreatePaymentDTO();
        paymentDTOController.setPaymentValue(23.0);
        paymentDTOController.setPaymentMethod("TC");
        paymentDTOController.setPaymentCountry("CO");
        paymentDTOController.setOrderReference("a4518c77-8884-4af9-bcf1-15d1bcf07b90");
        System.out.println("Create paymentDTOController");
        Payment payment = paymentMapper.paymentDtoToPayment(paymentDTOController);
        createPaymentCommand = new CreatePaymentCommand(payment);
        System.out.println(createPaymentCommand);
        System.out.println("Create CreatePaymentDTO");
        System.out.println(paymentDTOController);
        System.out.println("Finaliza setUp");
        this.payment = new Payment("TC",23.0,"CO",null,null,null,"a4518c77-8884-4af9-bcf1-15d1bcf07b90");
        createPaymentCommand.setPayment(this.payment);
    }

    @Test
    void createPayment() throws Exception {
        when(paymentMapper.paymentDtoToPayment(paymentDTOController)).thenReturn(payment);
        doNothing().when(commandBus).handle(createPaymentCommand);
        payment.setRequestMessage(PaymentConstantsTest.PAYMENTREQUEST);
        payment.setResponseMessage(PaymentConstantsTest.PAYMENTRESPONSE);
        paymentDTOController.setRequestMessage((PayURequest) paymentTransform.transformPaymentStringToObject(PaymentConstantsTest.PAYMENTREQUEST,new PayURequest()));
        paymentDTOController.setResponseMessage((PayUResponse) paymentTransform.transformPaymentStringToObject(PaymentConstantsTest.PAYMENTRESPONSE, new PayUResponse()));
        when(paymentMapper.paymentToPaymentDto(payment)).thenReturn(paymentDTOController);
        //paymentDTOController.setPaymentMethod("TD");
        ResponseEntity<CreatePaymentDTO> response = paymentController.createPayment(paymentDTOController);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(commandBus,times(1)).handle(createPaymentCommand);
    }
}