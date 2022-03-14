package com.mot.onlineshop.payment.infrastructure.rest.controllers;

import com.mot.onlineshop.payment.application.command.CreatePaymentCommand;
import com.mot.onlineshop.payment.application.command.RefundPaymendCommand;
import com.mot.onlineshop.payment.application.commandbus.CommandBus;
import com.mot.onlineshop.payment.application.query.GetPaymentQuery;
import com.mot.onlineshop.payment.application.querybus.QueryBus;
import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.infrastructure.rest.DTO.CreatePaymentDTO;
import com.mot.onlineshop.payment.infrastructure.rest.DTO.RefundPaymentDTO;
import com.mot.onlineshop.payment.infrastructure.rest.constants.PaymentConstants;
import com.mot.onlineshop.payment.infrastructure.rest.mappers.CreatePaymentMapper;
import com.mot.onlineshop.payment.infrastructure.rest.mappers.RefundPaymentMapper;
import com.mot.onlineshop.payment.infrastructure.rest.transform.PaymentTransform;
import com.mot.onlineshop.payment.infrastructure.validators.PaymentValidator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.validation.Validation;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/payment")
@AllArgsConstructor
public class PaymentController {
    private static final Logger log = LogManager.getLogger(PaymentController.class);

    private CommandBus commandBus;
    private QueryBus queryBus;
    private CreatePaymentMapper createPaymentMapper;
    private RefundPaymentMapper refundPaymentMapper;

    @PostMapping
    public ResponseEntity<CreatePaymentDTO> createPayment(@RequestBody CreatePaymentDTO paymentDTO) throws Exception {
        String methodSignature = "Inicializando método createPayment";
        log.info(methodSignature);
        log.info(PaymentConstants.REQUEST_IN_CONTROLLER +paymentDTO);
        PaymentValidator.builder().paymentDTO(paymentDTO).build().initValidation();
        log.info(PaymentConstants.REQUEST_IS_VALIDATED +paymentDTO);
        Payment paymentModel = createPaymentMapper.paymentDtoToPayment(paymentDTO);
        log.info(PaymentConstants.REQUEST_DTO_TO_MODEL +paymentModel);
        CreatePaymentCommand command = new CreatePaymentCommand(paymentModel);
        log.info(PaymentConstants.CREATE_COMMAND +command);
        commandBus.handle(command);
        log.info(PaymentConstants.COMMAND_TO_COMMAND_BUS +command);
        CreatePaymentDTO paymentDTO1 = createPaymentMapper.paymentToPaymentDto(command.getPayment());
        log.info(PaymentConstants.REQUEST_MODEL_TO_DTO +paymentDTO1);
        return ResponseEntity.ok(paymentDTO1);
    }

    @PostMapping("/refund")
    public ResponseEntity<RefundPaymentDTO> refundPayment(@RequestBody @NotNull RefundPaymentDTO refundPaymentDTO) throws Exception {
        String methodSignature = "Inicializando método refundPayment";
        log.info(methodSignature);
        log.info(PaymentConstants.REQUEST_IN_CONTROLLER +refundPaymentDTO);
        PaymentValidator paymentValidator = PaymentValidator.builder().build();
        paymentValidator.validationOfPaymentReference(refundPaymentDTO.getPaymentReference());
        log.info(PaymentConstants.REQUEST_IS_VALIDATED +refundPaymentDTO);
        Payment paymentModel = refundPaymentMapper.paymentDtoToPayment(refundPaymentDTO);
        log.info(PaymentConstants.REQUEST_DTO_TO_MODEL +paymentModel);
        RefundPaymendCommand command = new RefundPaymendCommand(paymentModel);
        log.info(PaymentConstants.CREATE_COMMAND +command);
        commandBus.handle(command);
        log.info(PaymentConstants.COMMAND_TO_COMMAND_BUS +command);
        RefundPaymentDTO refundPaymentDTO1 = refundPaymentMapper.paymentToPaymentDto(command.getPayment());
        PaymentValidator.builder().paymentDTO(refundPaymentDTO1).build().paymentDTOValidationNotNull();
        log.info(PaymentConstants.REQUEST_MODEL_TO_DTO +refundPaymentDTO1);
        return ResponseEntity.ok(refundPaymentDTO1);
    }

   /*   @GetMapping
    public ResponseEntity<Stream<CreatePaymentDTO>> getPaymentsAll() throws Exception {
         GetPaymentQuery query = new GetPaymentQuery();
         queryBus.handle(query);
         return ResponseEntity.ok(query.getPaymentsAll().map(payment -> new CreatePaymentDTO(payment)));
     }*/

     @GetMapping("/{paymentReference}")
     public ResponseEntity<CreatePaymentDTO> getPaymentReference(@PathVariable @NotNull String paymentReference) throws Exception {
         String methodSignature = "Inicializando método getPaymentReference";
         log.info(methodSignature);
         PaymentValidator paymentValidator = PaymentValidator.builder().build();
         log.info(PaymentConstants.REQUEST_IN_CONTROLLER +paymentReference);
         paymentValidator.validationOfPaymentReference(paymentReference);
         Payment payment = new Payment();
         payment.setPaymentReference(PaymentTransform.builder().payment(payment).build().transformPaymentReference(paymentReference));
         GetPaymentQuery query = new GetPaymentQuery(payment);
         log.info(PaymentConstants.CREATE_QUERY +query);
         Payment paymentResponse = queryBus.handle(query);
         log.info(PaymentConstants.QUERY_TO_QUERYBUS +query);
         log.info(paymentResponse);
         CreatePaymentDTO createPaymentDTO = new CreatePaymentDTO(paymentResponse);
         log.info(PaymentConstants.REQUEST_MODEL_TO_DTO +createPaymentDTO);
         PaymentValidator.builder().paymentDTO(createPaymentDTO).build().initValidation();
         return ResponseEntity.ok(createPaymentDTO);
     }

}
