package com.mot.onlineshop.payment.application.usecases;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.domain.models.PaymentId;
import com.mot.onlineshop.payment.domain.ports.clients.PaymentProvider;
import com.mot.onlineshop.payment.domain.ports.persistence.PaymentPersistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

class CreatePaymentUseCaseTest {
    @Mock
    private PaymentPersistence paymentPersistence;
    @Mock
    private PaymentProvider paymentProvider;

    @InjectMocks
    private CreatePaymentUseCase createPaymentUseCase;

    private Payment payment;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        payment = new Payment("TC",23.0,null,null,"a4518c77-8884-4af9-bcf1-15d1bcf07b90");
    }

    @Test
    void handle() throws Exception {
       // when(createPaymentUseCase.handle(any(PaymentId.class),any(Payment.class))).thenReturn(payment);
        //when(paymentProvider.getPaymentProvider(any(Payment.class))).thenReturn(payment);
        Payment paymentResponse = createPaymentUseCase.handle(payment.getPaymentReference(),payment);
        System.out.println("paymentResponse:"+paymentResponse);
        //assertNotNull(paymentResponse);
    }
}