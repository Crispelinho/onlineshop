package com.mot.onlineshop.payment.infrastructure.persistence.DAOS;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.mot.onlineshop.payment.infrastructure.persistence.entities.PaymentEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer> {

    public List<PaymentEntity> findAll();
}
