package com.mot.onlineshop.payment.infrastructure.persistence.postgres;

import com.mot.onlineshop.payment.domain.models.payment.Payment;
import com.mot.onlineshop.payment.domain.models.payment.PaymentId;
import com.mot.onlineshop.payment.domain.exceptions.BusinessException;
import com.mot.onlineshop.payment.infrastructure.persistence.DAOS.PaymentRepository;
import com.mot.onlineshop.payment.infrastructure.persistence.entities.PaymentEntity;
import com.mot.onlineshop.payment.infrastructure.rest.mappers.CreatePaymentMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import com.mot.onlineshop.payment.domain.ports.persistence.PaymentPersistence;

import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Repository @AllArgsConstructor
public class PaymentPersistencePostgres implements PaymentPersistence {

    private static Logger log = LogManager.getLogger(PaymentPersistencePostgres.class);

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    private CreatePaymentMapper paymentMapper;

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
        log.debug(methodSignature);
        log.info("Find payment with Payment Reference:["+paymentReference+"]");
        PaymentEntity paymentEntity = this.paymentRepository.findByPaymentReference(paymentReference.getId().toString());
        if (paymentEntity!=null){
            log.debug("Payment found");
            return this.paymentMapper.paymentEntityToPayment(paymentEntity);
        }
        if(paymentEntity == null || paymentEntity.getPaymentReference() == null) {
            throw new BusinessException("P-304",paymentReference.getId().toString(), HttpStatus.BAD_REQUEST);
        }
        log.warn("Payment not found");
        return null;
    }

    @Override
    public Payment persist(Payment payment) {
        String methodSignature = "Inicializando método persist";
        log.debug(methodSignature);
        log.info("Register payment with Payment Reference:["+payment.getPaymentReference()+"]");
        PaymentEntity paymentEntity = paymentMapper.paymentToPaymentEntity(payment);
        this.paymentRepository.save(paymentEntity);
        return payment;
    }
}
