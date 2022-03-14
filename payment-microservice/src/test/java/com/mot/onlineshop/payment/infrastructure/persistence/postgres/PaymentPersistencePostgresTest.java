package com.mot.onlineshop.payment.infrastructure.persistence.postgres;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.infrastructure.persistence.DAOS.PaymentRepository;
import com.mot.onlineshop.payment.infrastructure.persistence.entities.PaymentEntity;
import com.mot.onlineshop.payment.infrastructure.rest.constants.PaymentConstantsTest;
import com.mot.onlineshop.payment.infrastructure.rest.mappers.CreatePaymentMapper;
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
    @Mock
    private CreatePaymentMapper paymentMapper;

    @InjectMocks
    private PaymentPersistencePostgres paymentPersistencePostgres;

    private PaymentEntity paymentEntity;

    private Payment payment;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        paymentEntity = new PaymentEntity();
    //  paymentEntity.setRequestMessage(PaymentConstantsTest.PAYMENTREQUEST);
    //  paymentEntity.setResponseMessage(PaymentConstantsTest.PAYMENTRESPONSE);
        paymentEntity.setId(new BigInteger("11"));
        paymentEntity.setOrderReference("a4518c77-8884-4af9-bcf1-15d1bcf07b90");
        paymentEntity.setPaymentValue(50.00);
        paymentEntity.setPaymentReference("2ba09f62-e670-4855-81f5-3ff9d4386915");

        payment = new Payment("TC",50.00,"CO",null,PaymentConstantsTest.PAYMENTREQUEST,PaymentConstantsTest.PAYMENTRESPONSE,"a4518c77-8884-4af9-bcf1-15d1bcf07b90");
        payment.getPaymentReference().setId(UUID.fromString("2ba09f62-e670-4855-81f5-3ff9d4386915"));

    }

    @Test
    void findAll() {
    }

    @Test
    void findByPaymentReference() {

        when(paymentRepository.save(paymentEntity)).thenReturn(paymentEntity);
        when(paymentRepository.findByPaymentReference(paymentEntity.getPaymentReference())).thenReturn(paymentEntity);
        when(paymentMapper.paymentToPaymentEntity(payment)).thenReturn(paymentEntity);
        System.out.println(paymentPersistencePostgres.persist(payment));
        System.out.println("getPaymentReference:"+payment.getPaymentReference());
        Payment paymentResponse = paymentPersistencePostgres.findByPaymentReference(payment.getPaymentReference());
        assertNotNull(paymentPersistencePostgres.persist(payment));
        System.out.println("paymentResponse:"+paymentResponse);
       // assertEquals(payment,paymentResponse);
    }

    @Test
    void persist() {
        when(paymentRepository.save(paymentEntity)).thenReturn(paymentEntity);
        when(paymentMapper.paymentToPaymentEntity(payment)).thenReturn(paymentEntity);
        Payment paymentResponse = paymentPersistencePostgres.persist(payment);
        assertNotNull(paymentPersistencePostgres.persist(payment));
        assertEquals(payment,paymentResponse);
    }
}