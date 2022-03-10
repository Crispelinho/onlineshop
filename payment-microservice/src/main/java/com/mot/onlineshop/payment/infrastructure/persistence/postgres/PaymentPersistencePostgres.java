package com.mot.onlineshop.payment.infrastructure.persistence.postgres;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.domain.models.PaymentId;
import com.mot.onlineshop.payment.infrastructure.persistence.DAOS.PaymentRepository;
import com.mot.onlineshop.payment.infrastructure.persistence.entities.PaymentEntity;
import com.mot.onlineshop.payment.infrastructure.rest.mappers.PaymentMapper;
import com.mot.onlineshop.payment.infrastructure.rest.transform.PaymentTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mot.onlineshop.payment.domain.ports.persistence.PaymentPersistence;

import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Repository
public class PaymentPersistencePostgres implements PaymentPersistence {

    private static Logger log = LogManager.getLogger(PaymentPersistencePostgres.class);

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public Stream<Payment> findAll() {
       /* String methodSignature = "Inicializando método findAll";
        log.info(methodSignature);
        List<PaymentEntity> paymentList;
        if (this.paymentRepository.findAll() != null)
        {
            paymentList = this.paymentRepository.findAll();
            return paymentList.stream().map(paymentEntity -> paymentEntity.toPayment());
        }*/
        return null;
    }

    @Override
    public Payment findByPaymentReference(PaymentId paymentReference) {
        String methodSignature = "Inicializando método findByPaymentReference en PaymentPersistencePostgres";
        log.info(methodSignature);
        log.info("paymentReference:"+paymentReference);
        PaymentEntity paymentEntity = this.paymentRepository.findByPaymentReference(paymentReference.getId().toString());
        if (paymentEntity!=null){
            log.info("Payment encontrado");
            return paymentMapper.paymentEntityToPayment(paymentEntity);
        }
        log.info("Payment no encontrado");
        return null;
    }

    @Override
    public Payment persist(Payment payment) {
        String methodSignature = "Inicializando método persist";
        log.info(methodSignature);
        log.info(payment.getRequestMessage());
        PaymentEntity paymentEntity = paymentMapper.paymentToPaymentEntity(payment);
        this.paymentRepository.save(paymentEntity);
        return payment;
    }
}
