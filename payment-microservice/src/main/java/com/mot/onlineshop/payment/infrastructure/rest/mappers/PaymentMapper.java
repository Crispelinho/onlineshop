package com.mot.onlineshop.payment.infrastructure.rest.mappers;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.infrastructure.persistence.entities.PaymentEntity;
import com.mot.onlineshop.payment.infrastructure.rest.DTO.PaymentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {RequestMapper.class, ResponseMapper.class, PaymentReferenceMapper.class})
public interface PaymentMapper {

   PaymentDTO paymentEntitytoDto(PaymentEntity entity);
   @Mapping(ignore = true, target = "id")
   @Mapping(ignore = true,target = "datetimePayment")
   PaymentEntity paymentDtoToEntity (PaymentDTO paymentDTO);

   Payment paymentDtoToPayment(PaymentDTO paymentDTO);
   PaymentDTO paymentToPaymentDto(Payment payment);

   @Mapping(ignore = true, target = "id")
   Payment paymentEntityToPayment(PaymentEntity paymentEntity);
}
