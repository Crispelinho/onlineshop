package com.mot.onlineshop.payment.infrastructure.rest.controllers;

import com.mot.onlineshop.payment.application.command.CreatePaymentCommand;
import com.mot.onlineshop.payment.application.command.RefundPaymendCommand;
import com.mot.onlineshop.payment.application.commandbus.CommandBus;
import com.mot.onlineshop.payment.application.query.GetPaymentQuery;
import com.mot.onlineshop.payment.application.querybus.QueryBus;
import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.infrastructure.exceptions.BusinessException;
import com.mot.onlineshop.payment.infrastructure.models.providers.PayU.PaymentRefund;
import com.mot.onlineshop.payment.infrastructure.rest.DTO.CreatePaymentDTO;
import com.mot.onlineshop.payment.infrastructure.rest.DTO.RefundPaymentDTO;
import com.mot.onlineshop.payment.infrastructure.rest.constants.PaymentConstants;
import com.mot.onlineshop.payment.infrastructure.rest.mappers.CreatePaymentMapper;
import com.mot.onlineshop.payment.infrastructure.rest.mappers.RefundPaymentMapper;
import com.mot.onlineshop.payment.infrastructure.rest.transform.PaymentTransform;
import com.mot.onlineshop.payment.infrastructure.validators.PaymentValidator;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        log.info(PaymentConstants.REQUEST_EN_CONTROLLER +paymentDTO);
        PaymentValidator.builder().paymentDTO(paymentDTO).build().initValidation();
        log.info("Se valida request: "+paymentDTO);
        Payment paymentModel = createPaymentMapper.paymentDtoToPayment(paymentDTO);
        log.info("Se mapea Request DTO a model: "+paymentModel);
        CreatePaymentCommand command = new CreatePaymentCommand(paymentModel);
        log.info("Se crea command: "+command);
        commandBus.handle(command);
        //log.info("Se envía command al commandBus: "+command);
        CreatePaymentDTO paymentDTO1 = createPaymentMapper.paymentToPaymentDto(command.getPayment());
        //log.info("Se mapea Request model a DTO: "+paymentDTO1);
        return ResponseEntity.ok(paymentDTO1);
    }

    @PostMapping("/refund")
    public ResponseEntity<RefundPaymentDTO> refundPayment(@RequestBody @NotNull RefundPaymentDTO refundPaymentDTO) throws Exception {
        String methodSignature = "Inicializando método createPayment";
        log.info(methodSignature);
        log.info(PaymentConstants.REQUEST_EN_CONTROLLER +refundPaymentDTO);
        log.info("Se valida request: "+refundPaymentDTO);
        Payment paymentModel = refundPaymentMapper.paymentDtoToPayment(refundPaymentDTO);
        log.info("Se mapea Request DTO a model: "+paymentModel);
        RefundPaymendCommand command = new RefundPaymendCommand(paymentModel);
        log.info("Se crea command: "+command);
        commandBus.handle(command);
        log.info("Se envía command al commandBus: "+command);
        RefundPaymentDTO refundPaymentDTO1 = refundPaymentMapper.paymentToPaymentDto(command.getPayment());
        PaymentValidator.builder().paymentDTO(refundPaymentDTO1).build().paymentDTOValidationNotNull();
        log.info("Se mapea Request model a DTO: "+refundPaymentDTO1);
        return ResponseEntity.ok(refundPaymentDTO1);
    }

   /*   @GetMapping
    public ResponseEntity<Stream<CreatePaymentDTO>> getPaymentsAll() throws Exception {
         GetPaymentQuery query = new GetPaymentQuery();
         queryBus.handle(query);
         return ResponseEntity.ok(query.getPaymentsAll().map(payment -> new CreatePaymentDTO(payment)));
     }*/

     @GetMapping("/{paymentReference}")
     public ResponseEntity<CreatePaymentDTO> getPaymentReference(@PathVariable String paymentReference) throws Exception {
         log.info(paymentReference);
         Payment payment = new Payment();
         payment.setPaymentReference(PaymentTransform.builder().payment(payment).build().transformPaymentReference(paymentReference));
         GetPaymentQuery query = new GetPaymentQuery(payment);
         Payment paymentResponse = queryBus.handle(query);
         log.info(paymentResponse);
         CreatePaymentDTO createPaymentDTO = new CreatePaymentDTO(paymentResponse);
         PaymentValidator.builder().paymentDTO(createPaymentDTO).build().initValidation();
         return ResponseEntity.ok(createPaymentDTO);
     }

}
