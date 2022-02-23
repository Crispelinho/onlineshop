package com.mot.onlineshop.payment.infrastructure.rest.controllers;

import com.mot.onlineshop.payment.domain.model.Payment;
import com.mot.onlineshop.payment.domain.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
