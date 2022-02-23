package com.mot.onlineshop.infrastructure.rest.controllers;

import com.mot.onlineshop.application.command.CreatePaymentCommand;
import com.mot.onlineshop.domain.model.Payment;
import com.mot.onlineshop.domain.services.PaymentService;
import com.mot.onlineshop.infrastructure.rest.DTO.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<String> createPayment(@RequestBody Payment payment) throws Exception {
        if(payment.getPaymentMethod().toString().isEmpty() && payment.getPaymentValue().isNaN()
                && payment.getPayload().isEmpty() && payment.getOrderReference() != null)
        {
            //Payment payment = new Payment(paymentMethod,paymentValue,payload,orderReference);
            //CreatePaymentCommand command = new CreatePaymentCommand(payment);
            //commandBus.handle(command);
           // PaymentDTO paymentDTO1 = new PaymentDTO(this.paymentService.createPayment());
        }

        return ResponseEntity.ok().build();
    }
}
