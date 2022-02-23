package com.mot.onlineshop.payment.infrastructure.persistence.postgres;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.domain.models.PaymentId;
import com.mot.onlineshop.payment.infrastructure.persistence.DAOS.PaymentRepository;
import com.mot.onlineshop.payment.infrastructure.persistence.entities.PaymentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mot.onlineshop.payment.domain.persistence_ports.PaymentPersistence;

import java.util.List;
import java.util.stream.Stream;

@Repository
public class PaymentPersistencePostgres implements PaymentPersistence {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public Stream<Payment> findAll() {
        List<PaymentEntity> paymentList;
        if (this.paymentRepository.findAll() != null)
        {
            paymentList = this.paymentRepository.findAll();
            return paymentList.stream().map(paymentEntity -> paymentEntity.toPayment());
        }
        return null;
    }
}
