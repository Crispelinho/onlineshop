package com.mot.onlineshop.payment.infrastructure.persistence.DAOS;

import java.util.List;
import com.mot.onlineshop.payment.infrastructure.persistence.entities.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer> {

    public List<PaymentEntity> findAll();

    public PaymentEntity findByPaymentReference(String paymentId);

    public PaymentEntity save(PaymentEntity payment);
}
