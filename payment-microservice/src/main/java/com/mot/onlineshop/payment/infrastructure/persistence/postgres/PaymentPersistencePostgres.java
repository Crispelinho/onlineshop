package com.mot.onlineshop.payment.infrastructure.persistence.postgres;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.domain.models.PaymentId;
import com.mot.onlineshop.payment.infrastructure.persistence.DAOS.PaymentRepository;
import com.mot.onlineshop.payment.infrastructure.persistence.entities.PaymentEntity;
import com.mot.onlineshop.payment.infrastructure.rest.Transfoms.PaymentTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mot.onlineshop.payment.domain.persistence_ports.PaymentPersistence;
import java.util.List;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Repository
public class PaymentPersistencePostgres implements PaymentPersistence {

    private static Logger log = LogManager.getLogger(PaymentPersistencePostgres.class);

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

    @Override
    public Payment findByPaymentReference(PaymentId paymentReference) {

        log.info("paymentReference:"+paymentReference);
        return this.paymentRepository.findByPaymentReference(paymentReference.getId().toString()).toPayment();
    }

    @Override
    public Payment persist(Payment payment) {
        log.info("Entrando a método persist");
        log.info("payment:" + payment);
        PaymentTransform paymentTransform = new PaymentTransform(payment);
        this.paymentRepository.save(paymentTransform.convertToEntity());
        return null;
    }
}
