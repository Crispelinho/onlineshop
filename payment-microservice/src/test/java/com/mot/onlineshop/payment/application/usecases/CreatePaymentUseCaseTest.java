package com.mot.onlineshop.payment.application.usecases;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.domain.ports.clients.PaymentProvider;
import com.mot.onlineshop.payment.domain.ports.persistence.PaymentPersistence;
import com.mot.onlineshop.payment.infrastructure.rest.constants.PaymentConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreatePaymentUseCaseTest {
    @Mock
    private PaymentPersistence paymentPersistence;
    @Mock
    private PaymentProvider paymentProvider;

    @InjectMocks
    private CreatePaymentUseCase createPaymentUseCase;

    private Payment payment;
    private Payment paymentResponse;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        payment = new Payment("TC",23.0,null,null,"a4518c77-8884-4af9-bcf1-15d1bcf07b90");
        paymentResponse = payment;
        paymentResponse.setRequestMessage(PaymentConstants.PAYMENTREQUEST);
        paymentResponse.setResponseMessage(PaymentConstants.PAYMENTRESPONSE);
    }

    @Test
    void handle() throws Exception {
        when(paymentProvider.postPaymentProvider(payment)).thenReturn(paymentResponse);
        when(paymentPersistence.persist(payment)).thenReturn(paymentResponse);
        Payment paymentResponse = createPaymentUseCase.handle(payment.getPaymentReference(),payment);
        System.out.println("paymentResponse:"+paymentResponse);
        assertNotNull(paymentResponse);
        assertEquals(this.paymentResponse,paymentResponse);
        verify(paymentProvider,times(1)).postPaymentProvider(payment);
        verify(paymentPersistence,times(1)).persist(payment);
    }
}