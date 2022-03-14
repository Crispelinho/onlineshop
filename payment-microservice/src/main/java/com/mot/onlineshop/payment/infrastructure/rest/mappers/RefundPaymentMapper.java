package com.mot.onlineshop.payment.infrastructure.rest.mappers;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.infrastructure.persistence.entities.PaymentEntity;
import com.mot.onlineshop.payment.infrastructure.rest.DTO.RefundPaymentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {RefundPaymentRequestMapper.class, RefundPaymentResponseMapper.class, PaymentReferenceMapper.class, DatetimePaymentMapper.class, PayloadMapper.class})
public interface RefundPaymentMapper {
    RefundPaymentDTO paymentEntitytoDto(PaymentEntity entity);
    @Mapping(ignore = true, target = "id")
    PaymentEntity paymentDtoToEntity (RefundPaymentDTO paymentDTO);

    @Mapping(ignore = true,target = "datetimePayment")
    Payment paymentDtoToPayment(RefundPaymentDTO createPaymentDTO);

    RefundPaymentDTO paymentToPaymentDto(Payment payment);

    @Mapping(ignore = true, target = "id")
    Payment paymentEntityToPayment(PaymentEntity paymentEntity);

    //@Mapping(ignore = true, target = "requestMessage")
    //@Mapping(ignore = true, target = "responseMessage")
    PaymentEntity paymentToPaymentEntity(Payment payment);
}
