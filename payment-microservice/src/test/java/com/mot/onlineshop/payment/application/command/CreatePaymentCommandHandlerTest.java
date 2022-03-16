package com.mot.onlineshop.payment.application.command;

import com.mot.onlineshop.payment.application.commandbus.CommandHandler;
import com.mot.onlineshop.payment.application.usecases.CreatePaymentUseCase;
import com.mot.onlineshop.payment.domain.interfaces.EventRepository;
import com.mot.onlineshop.payment.domain.models.event.Event;
import com.mot.onlineshop.payment.domain.models.event.EventId;
import com.mot.onlineshop.payment.domain.models.payment.Payment;
import com.mot.onlineshop.payment.domain.ports.clients.ApiClient;
import com.mot.onlineshop.payment.domain.ports.clients.PaymentProvider;
import com.mot.onlineshop.payment.domain.ports.persistence.PaymentPersistence;
import com.mot.onlineshop.payment.infrastructure.bus.InMemoryCommandBus;
import com.mot.onlineshop.payment.infrastructure.bus.InMemoryEventRepository;
import com.mot.onlineshop.payment.infrastructure.models.converters.ModelConverter;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayURequest;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PayUResponse;
import com.mot.onlineshop.payment.infrastructure.persistence.memory.InMemoryPersistence;
import com.mot.onlineshop.payment.infrastructure.rest.clients.PaymentProviderImp;
import com.mot.onlineshop.payment.infrastructure.rest.constants.PaymentConstantsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    private Payment paymentCommand;
    private Payment paymentResult;
    private CreatePaymentCommand createPaymentCommand;

    private EventId eventId;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        payment = new Payment("TC",23.0,"CO",null,null,null,"a4518c77-8884-4af9-bcf1-15d1bcf07b90");
        paymentCommand = payment;
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