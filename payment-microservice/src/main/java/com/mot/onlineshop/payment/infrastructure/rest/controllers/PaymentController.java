package com.mot.onlineshop.payment.infrastructure.rest.controllers;

import com.mot.onlineshop.payment.application.command.CreatePaymentCommand;
import com.mot.onlineshop.payment.application.commandbus.CommandBus;
import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.domain.ports.clients.ApiClient;
import com.mot.onlineshop.payment.infrastructure.rest.DTO.PaymentDTO;
import com.mot.onlineshop.payment.infrastructure.rest.mappers.PaymentMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/payment")
@AllArgsConstructor
public class PaymentController {
    private static Logger log = LogManager.getLogger(PaymentController.class);

    @Autowired
    ApiClient paymentService;

    private CommandBus commandBus;
   // private QueryBus queryBus;

    @PostMapping
    public ResponseEntity<PaymentDTO> createPayment(@RequestBody PaymentDTO paymentDTO) throws Exception {
        String methodSignature = "Inicializando método createPayment";
        log.info(methodSignature);
        if(!paymentDTO.getPaymentMethod().isEmpty() && !paymentDTO.getPaymentValue().isNaN()
                && paymentDTO.getOrderReference() != null)
        {
            log.info(paymentDTO);
            PaymentMapper paymentTransform = new PaymentMapper();
            Payment newPayment = paymentTransform.convertToModel(paymentDTO);
            CreatePaymentCommand command = new CreatePaymentCommand(newPayment);
            commandBus.handle(command);
        }

        return ResponseEntity.ok().build();
    }

    // @GetMapping
    // public ResponseEntity<Stream<PaymentDTO>> getPaymentsAll(){
    //     return ResponseEntity.ok(this.paymentService.getPaymentsAll().map(payment -> new PaymentDTO(payment)));
    // }

    // @GetMapping("/{id}")
    // public ResponseEntity<PaymentDTO> getPaymentReference(String paymentReference){
    //     return ResponseEntity.ok(new PaymentDTO(this.paymentService.getPaymentReference(
    //             PaymentTransform.builder().build().transformPaymentReference(paymentReference))));
    // }

}
