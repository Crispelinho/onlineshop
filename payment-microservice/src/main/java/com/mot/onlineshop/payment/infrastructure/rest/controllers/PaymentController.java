package com.mot.onlineshop.payment.infrastructure.rest.controllers;

import com.mot.onlineshop.payment.application.command.CreatePaymentCommand;
import com.mot.onlineshop.payment.application.commandbus.CommandBus;
import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.domain.services.PaymentService;
import com.mot.onlineshop.payment.infrastructure.rest.DTO.PaymentDTO;
import com.mot.onlineshop.payment.infrastructure.rest.Transfoms.PaymentTransform;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Stream;

@RestController
@RequestMapping("/payment")
@AllArgsConstructor
public class PaymentController {
    private static Logger log = LogManager.getLogger(PaymentController.class);

    @Autowired
    PaymentService paymentService;

    private CommandBus commandBus;
   // private QueryBus queryBus;

    @PostMapping
    public ResponseEntity<PaymentDTO> createPayment(@RequestBody PaymentDTO paymentDTO) throws Exception {

        log.info("Entrando en el controller createPayment");
        if(!paymentDTO.getPaymentMethod().isEmpty() && !paymentDTO.getPaymentValue().isNaN()
                && paymentDTO.getOrderReference() != null)
        {
            log.info(paymentDTO);
            PaymentTransform paymentTransform = new PaymentTransform();
            Payment newPayment = paymentTransform.convertToModel(paymentDTO);
            CreatePaymentCommand command = new CreatePaymentCommand(newPayment);
            commandBus.handle(command);
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Stream<PaymentDTO>> getPaymentsAll(){
        return ResponseEntity.ok(this.paymentService.getPaymentsAll().map(payment -> new PaymentDTO(payment)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> getPaymentReference(String paymentReference){
        return ResponseEntity.ok(new PaymentDTO(this.paymentService.getPaymentReference(
                PaymentTransform.builder().build().transformPaymentReference(paymentReference))));
    }

}
