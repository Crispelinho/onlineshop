package com.mot.onlineshop.payment.infrastructure.persistence.postgres;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.infrastructure.persistence.DAOS.PaymentRepository;
import com.mot.onlineshop.payment.infrastructure.persistence.entities.PaymentEntity;
import com.mot.onlineshop.payment.infrastructure.rest.constants.PaymentConstants;
import com.mot.onlineshop.payment.infrastructure.rest.models.PayURequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigInteger;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PaymentPersistencePostgresTest {

    @Mock
    PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentPersistencePostgres paymentPersistencePostgres;

    private PaymentEntity paymentEntity;

    private Payment payment;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        paymentEntity = new PaymentEntity();
        paymentEntity.setRequestMessage(PaymentConstants.PAYMENTREQUEST);
        paymentEntity.setResponseMessage(PaymentConstants.PAYMENTRESPONSE);
        paymentEntity.setId(new BigInteger("11"));
        paymentEntity.setOrderReference("a4518c77-8884-4af9-bcf1-15d1bcf07b90");
        paymentEntity.setPaymentValue(50.00);
        paymentEntity.setPaymentReference("2ba09f62-e670-4855-81f5-3ff9d4386915");

        payment = new Payment("TC",50.00,PaymentConstants.PAYMENTREQUEST,PaymentConstants.PAYMENTRESPONSE,"a4518c77-8884-4af9-bcf1-15d1bcf07b90");
        payment.getPaymentReference().setId(UUID.fromString("2ba09f62-e670-4855-81f5-3ff9d4386915"));

    }

    @Test
    void findAll() {
    }

    @Test
    void findByPaymentReference() {

    }

    @Test
    void persist() {
        when(paymentRepository.save(any(PaymentEntity.class))).thenReturn(paymentEntity);
        Payment paymentResponse = paymentPersistencePostgres.persist(payment);
        assertNotNull(paymentPersistencePostgres.persist(payment));
        assertEquals(payment,paymentResponse);
    }
}