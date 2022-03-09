package com.mot.onlineshop.payment.infrastructure.rest.controllers;

import com.mot.onlineshop.payment.application.command.CreatePaymentCommand;
import com.mot.onlineshop.payment.application.commandbus.CommandBus;
import com.mot.onlineshop.payment.application.query.GetPaymentQuery;
import com.mot.onlineshop.payment.application.querybus.QueryBus;
import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.infrastructure.exceptions.BusinessException;
import com.mot.onlineshop.payment.infrastructure.rest.DTO.PaymentDTO;
import com.mot.onlineshop.payment.infrastructure.rest.transform.PaymentTransform;
import com.mot.onlineshop.payment.infrastructure.validators.PaymentValidator;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/payment")
@AllArgsConstructor
public class PaymentController {
    private static final Logger log = LogManager.getLogger(PaymentController.class);

    private CommandBus commandBus;
    private QueryBus queryBus;

    @PostMapping
    public ResponseEntity<PaymentDTO> createPayment(@RequestBody PaymentDTO paymentDTO) throws Exception {
        String methodSignature = "Inicializando método createPayment";
        log.info(methodSignature);
        log.info("Se recibe request en controller: "+paymentDTO);
        PaymentValidator.builder().paymentDTO(paymentDTO).build().initValidation();
        log.info("Se valida request: "+paymentDTO);
        PaymentTransform paymentMapper = new PaymentTransform();
        Payment paymentModel = paymentMapper.convertToModel(paymentDTO);
        log.info("Se mapea Request DTO a model: "+paymentModel);
        CreatePaymentCommand command = new CreatePaymentCommand(paymentModel);
        log.info("Se crea command: "+command);
        commandBus.handle(command);
        log.info("Se envía command al commandBus: "+command);
        PaymentDTO paymentDTO1 = new PaymentDTO(command.getPayment());
        log.info("Se mapea Request model a DTO: "+paymentModel);
        return ResponseEntity.ok(paymentDTO1);
    }

   /*   @GetMapping
    public ResponseEntity<Stream<PaymentDTO>> getPaymentsAll() throws Exception {
         GetPaymentQuery query = new GetPaymentQuery();
         queryBus.handle(query);
         return ResponseEntity.ok(query.getPaymentsAll().map(payment -> new PaymentDTO(payment)));
     }*/

     @GetMapping("/{paymentReference}")
     public ResponseEntity<PaymentDTO> getPaymentReference(@PathVariable String paymentReference) throws Exception {
         log.info(paymentReference);
         Payment payment = new Payment();
         payment.setPaymentReference(PaymentTransform.builder().payment(payment).build().transformPaymentReference(paymentReference));
         GetPaymentQuery query = new GetPaymentQuery(payment);
         Payment paymentResponse = queryBus.handle(query);
         log.info(paymentResponse);
         if (paymentResponse==null){
             throw new BusinessException("P-304", HttpStatus.NO_CONTENT);
         }
         return ResponseEntity.ok(new PaymentDTO(paymentResponse));
     }

}
