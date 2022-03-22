package com.mot.onlineshop.payment.application.usecases;

import com.mot.onlineshop.payment.domain.interfaces.EventRepository;
import com.mot.onlineshop.payment.domain.models.event.EventId;
import com.mot.onlineshop.payment.domain.models.payment.Payment;
import com.mot.onlineshop.payment.domain.ports.clients.PaymentProvider;
import com.mot.onlineshop.payment.domain.ports.persistence.PaymentPersistence;
import com.mot.onlineshop.payment.domain.shared.domaineventbus.DomainEventBus;
import com.mot.onlineshop.payment.infrastructure.transversal.constants.PaymentConstantsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreatePaymentUseCaseTest {
    @Mock
    private PaymentPersistence paymentPersistence;
    @Mock
    private PaymentProvider paymentProvider;
    @Mock
    private EventRepository eventRepository;
    @Mock
    private DomainEventBus domainEventBus;
    @InjectMocks
    private CreatePaymentUseCase createPaymentUseCase;

    private Payment payment;
    private Payment paymentResponse;
    private EventId eventId;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        payment = new Payment("TC",23.0,"CO",null,null,null,"a4518c77-8884-4af9-bcf1-15d1bcf07b90");
        paymentResponse = payment;
        paymentResponse.setRequestMessage(PaymentConstantsTest.PAYMENTREQUEST);
        paymentResponse.setResponseMessage(PaymentConstantsTest.PAYMENTRESPONSE);
        eventId = eventRepository.getId();
    }

    @Test
    void handle() throws Exception {
        when(paymentProvider.postPaymentProvider(payment)).thenReturn(paymentResponse);
        when(paymentPersistence.persist(payment)).thenReturn(paymentResponse);
        Payment paymentResponse = createPaymentUseCase.handle(eventId,payment);
        System.out.println("paymentResponse:"+paymentResponse);
        assertNotNull(paymentResponse);
        assertEquals(this.paymentResponse,paymentResponse);
        verify(paymentProvider,times(1)).postPaymentProvider(payment);
        verify(paymentPersistence,times(1)).persist(payment);
    }
}