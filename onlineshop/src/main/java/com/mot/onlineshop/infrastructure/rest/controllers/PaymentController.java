package com.mot.onlineshop.infrastructure.rest.controllers;

import com.mot.onlineshop.application.command.CreatePaymentCommand;
import com.mot.onlineshop.domain.model.payment.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @PostMapping
    public ResponseEntity<String> createPayment(@RequestParam("paymentMethod") String paymentMethod, @RequestParam("paymentValue") Double paymentValue,
                                                @RequestParam("payload") String payload, @RequestParam("orderReference") UUID orderReference ) throws Exception {
        if(paymentMethod.isEmpty() && paymentValue.isNaN() && payload.isEmpty() && orderReference != null)
        {
            Payment payment = new Payment(paymentMethod,paymentValue,payload,orderReference);
            CreatePaymentCommand command = new CreatePaymentCommand(payment);
            //commandBus.handle(command);
        }

        return ResponseEntity.ok().build();
    }
}
