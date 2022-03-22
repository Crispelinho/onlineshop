package com.mot.onlineshop.payment.infrastructure.ports.rest.api.controllers;

import com.mot.onlineshop.payment.application.command.CreatePaymentCommand;
import com.mot.onlineshop.payment.application.command.RefundPaymendCommand;
import com.mot.onlineshop.payment.application.commandbus.CommandBus;
import com.mot.onlineshop.payment.application.query.GetPaymentQuery;
import com.mot.onlineshop.payment.application.querybus.QueryBus;
import com.mot.onlineshop.payment.domain.models.payment.Payment;
import com.mot.onlineshop.payment.infrastructure.ports.rest.api.DTOs.CreatePaymentDTO;
import com.mot.onlineshop.payment.infrastructure.ports.rest.api.DTOs.RefundPaymentDTO;
import com.mot.onlineshop.payment.infrastructure.ports.rest.api.validators.PaymentValidator;
import com.mot.onlineshop.payment.infrastructure.transversal.mappers.PaymentMapper;
import com.mot.onlineshop.payment.infrastructure.transversal.constants.PaymentConstants;
import com.mot.onlineshop.payment.infrastructure.transversal.mappers.RefundPaymentMapper;
import com.mot.onlineshop.payment.infrastructure.transversal.transform.PaymentTransform;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("/payment")
@Validated
@AllArgsConstructor
public class PaymentController {
    private static final Logger log = LogManager.getLogger(PaymentController.class);

    private CommandBus commandBus;
    private QueryBus queryBus;
    private PaymentMapper paymentMapper;
    private RefundPaymentMapper refundPaymentMapper;

    @PostMapping
    public ResponseEntity<CreatePaymentDTO> createPayment(@RequestBody @Valid CreatePaymentDTO paymentDTO) throws Exception {
        String methodSignature = "Initialization method in createPayment";
        log.debug(methodSignature);
        log.info(PaymentConstants.REQUEST_IN_CONTROLLER +paymentDTO);
        PaymentValidator.builder().paymentDTO(paymentDTO).build().initValidation();
        Payment paymentModel = paymentMapper.paymentDtoToPayment(paymentDTO);
        CreatePaymentCommand command = new CreatePaymentCommand(paymentModel);
        commandBus.handle(command);
        log.debug(PaymentConstants.COMMAND_TO_COMMAND_BUS +command);
        CreatePaymentDTO paymentDTO1 = paymentMapper.paymentToPaymentDto(command.getPayment());
        return ResponseEntity.ok(paymentDTO1);
    }

    @PostMapping("/refund")
    public ResponseEntity<RefundPaymentDTO> refundPayment(@RequestBody RefundPaymentDTO refundPaymentDTO) throws Exception {
        String methodSignature = "Initialization method in refundPayment";
        log.debug(methodSignature);
        log.info(PaymentConstants.REQUEST_IN_CONTROLLER +refundPaymentDTO);
        PaymentValidator paymentValidator = PaymentValidator.builder().build();
        paymentValidator.validationOfPaymentReference(refundPaymentDTO.getPaymentReference());
        Payment paymentModel = refundPaymentMapper.paymentDtoToPayment(refundPaymentDTO);
        RefundPaymendCommand command = new RefundPaymendCommand(paymentModel);
        commandBus.handle(command);
        log.debug(PaymentConstants.COMMAND_TO_COMMAND_BUS +command);
        RefundPaymentDTO refundPaymentDTO1 = refundPaymentMapper.paymentToPaymentDto(command.getPayment());
        PaymentValidator.builder().paymentDTO(refundPaymentDTO1).build().paymentValidationNotFound();
        return ResponseEntity.ok(refundPaymentDTO1);
    }

   /*   @GetMapping
    public ResponseEntity<Stream<CreatePaymentDTO>> getPaymentsAll() throws Exception {
         GetPaymentQuery query = new GetPaymentQuery();
         queryBus.handle(query);
         return ResponseEntity.ok(query.getPaymentsAll().map(payment -> new CreatePaymentDTO(payment)));
     }*/

     @GetMapping("/{paymentReference}")
     public ResponseEntity<CreatePaymentDTO> getPaymentReference(@PathVariable @NotNull @Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{4}-[89ab][0-9a-f]{4}-[0-9a-f]{12}$") String paymentReference) throws Exception {
         String methodSignature = "Initialization method in getPaymentReference";
         log.debug(methodSignature);
         PaymentValidator paymentValidator = PaymentValidator.builder().build();
         log.info(PaymentConstants.REQUEST_IN_CONTROLLER +paymentReference);
         paymentValidator.validationOfPaymentReference(paymentReference);
         Payment payment = new Payment();
         payment.setPaymentReference(PaymentTransform.builder().payment(payment).build().transformPaymentReference(paymentReference));
         GetPaymentQuery query = new GetPaymentQuery(payment);
         Payment paymentResponse = queryBus.handle(query);
         log.debug(PaymentConstants.QUERY_TO_QUERYBUS +query);
         CreatePaymentDTO createPaymentDTO = new CreatePaymentDTO(paymentResponse);
         PaymentValidator.builder().paymentDTO(createPaymentDTO).build().initValidation();
         return ResponseEntity.ok(createPaymentDTO);
     }

}
