package com.mot.onlineshop.payment.infrastructure.rest.mappers;

import com.mot.onlineshop.payment.infrastructure.persistence.entities.PaymentEntity;
import com.mot.onlineshop.payment.infrastructure.rest.DTO.PaymentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
/*
   PaymentDTO Dto(PaymentEntity entity);
   @Mapping(ignore = true, target = "id")
   @Mapping(ignore = true,target = "datetimePayment")
   @Mapping(ignore = true, target = "requestMessage")
   @Mapping(ignore = true, target = "responseMessage")
  PaymentEntity toDto (PaymentDTO paymentDTO);*/
}
