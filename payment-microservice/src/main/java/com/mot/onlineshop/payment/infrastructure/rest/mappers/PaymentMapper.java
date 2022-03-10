package com.mot.onlineshop.payment.infrastructure.rest.mappers;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.infrastructure.persistence.entities.PaymentEntity;
import com.mot.onlineshop.payment.infrastructure.rest.DTO.PaymentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {RequestMapper.class, ResponseMapper.class, PaymentReferenceMapper.class, DatetimePayment.class})
public interface PaymentMapper {

   PaymentDTO paymentEntitytoDto(PaymentEntity entity);
   @Mapping(ignore = true, target = "id")
   PaymentEntity paymentDtoToEntity (PaymentDTO paymentDTO);

   @Mapping(ignore = true, target = "paymentReference")
   @Mapping(ignore = true,target = "datetimePayment")
   Payment paymentDtoToPayment(PaymentDTO paymentDTO);
   PaymentDTO paymentToPaymentDto(Payment payment);

   @Mapping(ignore = true, target = "id")
   Payment paymentEntityToPayment(PaymentEntity paymentEntity);

   @Mapping(ignore = true, target = "requestMessage")
   @Mapping(ignore = true, target = "responseMessage")
   PaymentEntity paymentToPaymentEntity(Payment payment);
}
