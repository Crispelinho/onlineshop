package com.mot.onlineshop.payment.infrastructure.rest.mappers;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.infrastructure.persistence.entities.PaymentEntity;
import com.mot.onlineshop.payment.infrastructure.rest.DTO.CreatePaymentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {CreatePaymentRequestMapper.class, CreatePaymentResponseMapper.class, PaymentReferenceMapper.class, DatetimePaymentMapper.class, PayloadMapper.class})
public interface CreatePaymentMapper {

   CreatePaymentDTO paymentEntitytoDto(PaymentEntity entity);
   @Mapping(ignore = true, target = "id")
   PaymentEntity paymentDtoToEntity (CreatePaymentDTO paymentDTO);

   @Mapping(ignore = true,target = "datetimePayment")
   Payment paymentDtoToPayment(CreatePaymentDTO createPaymentDTO);

   CreatePaymentDTO paymentToPaymentDto(Payment payment);

   @Mapping(ignore = true, target = "id")
   Payment paymentEntityToPayment(PaymentEntity paymentEntity);

//   @Mapping(ignore = true, target = "requestMessage")
//   @Mapping(ignore = true, target = "responseMessage")
   PaymentEntity paymentToPaymentEntity(Payment payment);
}
