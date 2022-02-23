package com.mot.onlineshop.payment.infrastructure.rest.controllers;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.domain.services.PaymentService;
import com.mot.onlineshop.payment.infrastructure.rest.DTO.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

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

    @GetMapping
    public Stream<PaymentDTO> getPaymentsAll(){
        return this.paymentService.getPaymentsAll().map(payment -> new PaymentDTO(payment));
    }

}
