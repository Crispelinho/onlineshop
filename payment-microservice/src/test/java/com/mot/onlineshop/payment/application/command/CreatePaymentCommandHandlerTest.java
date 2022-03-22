package com.mot.onlineshop.payment.application.command;

import com.mot.onlineshop.payment.application.usecases.CreatePaymentUseCase;
import com.mot.onlineshop.payment.domain.interfaces.EventRepository;
import com.mot.onlineshop.payment.domain.models.event.EventId;
import com.mot.onlineshop.payment.domain.models.payment.Payment;
import com.mot.onlineshop.payment.infrastructure.transversal.constants.PaymentConstantsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class CreatePaymentCommandHandlerTest {

    @Mock
    private CreatePaymentUseCase createPaymentUseCase;
    @Mock
    private EventRepository eventRepository;
    @InjectMocks
    private CreatePaymentCommandHandler createPaymentCommandHandler;

    private Payment payment;
    private Payment paymentResult;
    private CreatePaymentCommand createPaymentCommand;

    private EventId eventId;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        payment = new Payment("TC",23.0,"CO",null,null,null,"a4518c77-8884-4af9-bcf1-15d1bcf07b90");
        Payment paymentCommand = payment;
        paymentCommand.getPaymentReference().setId(UUID.randomUUID());
        paymentCommand.setDatetimePayment(LocalDateTime.now(ZoneId.of("UTC")).minusHours(5L));
        createPaymentCommand = new CreatePaymentCommand(payment);
        createPaymentCommand.setPayment(paymentCommand);
        paymentResult = paymentCommand;
        paymentResult.setRequestMessage(PaymentConstantsTest.PAYMENTREQUEST);
        paymentResult.setResponseMessage(PaymentConstantsTest.PAYMENTRESPONSE);
        eventId = new EventId();
    }

    @Test
    void handle() throws Exception {
        when(eventRepository.getId()).thenReturn(eventId);
        when(createPaymentUseCase.handle(eventId,payment)).thenReturn(paymentResult);
        createPaymentCommandHandler.handle(createPaymentCommand);
        verify(eventRepository,times(1)).getId();
        verify(createPaymentUseCase,times(1)).handle(eventId,payment);
    }
}