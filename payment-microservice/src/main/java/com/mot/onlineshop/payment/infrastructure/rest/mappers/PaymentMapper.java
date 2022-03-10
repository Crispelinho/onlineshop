package com.mot.onlineshop.payment.infrastructure.rest.mappers;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.infrastructure.persistence.entities.PaymentEntity;
import com.mot.onlineshop.payment.infrastructure.rest.DTO.PaymentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {RequestMapper.class, ResponseMapper.class, PaymentReferenceMapper.class})
public interface PaymentMapper {

   PaymentDTO Dto(PaymentEntity entity);
   @Mapping(ignore = true, target = "id")
   @Mapping(ignore = true,target = "datetimePayment")
   PaymentEntity toDto (PaymentDTO paymentDTO);

   /*
   @Mapping(ignore = true, target = "requestMessage")
   @Mapping(ignore = true, target = "responseMessage")
   Payment Model(PaymentDTO paymentDTO);
   @Mapping(ignore = true, target = "requestMessage")
   @Mapping(ignore = true, target = "responseMessage")
   PaymentDTO toModel(Payment payment);

   Payment toModel(PaymentEntity paymentEntity);*/
}
