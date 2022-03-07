package com.mot.onlineshop.payment.infrastructure.rest.controllers;

import com.mot.onlineshop.payment.application.command.CreatePaymentCommand;
import com.mot.onlineshop.payment.application.commandbus.CommandBus;
import com.mot.onlineshop.payment.application.query.GetPaymentQuery;
import com.mot.onlineshop.payment.application.querybus.QueryBus;
import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.infrastructure.exceptions.RequestException;
import com.mot.onlineshop.payment.infrastructure.rest.DTO.PaymentDTO;
import com.mot.onlineshop.payment.infrastructure.rest.mappers.PaymentMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;
import java.util.stream.Stream;

@RestController
@RequestMapping("/payment")
@AllArgsConstructor
public class PaymentController {
    private static final Logger log = LogManager.getLogger(PaymentController.class);

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
            PaymentMapper paymentMapper = new PaymentMapper();
            Payment newPayment = paymentMapper.convertToModel(paymentDTO);
            log.info(newPayment);
            CreatePaymentCommand command = new CreatePaymentCommand(newPayment);
            log.info(command);
            commandBus.handle(command);
            log.info("--------------------------------------------------");
            log.info(command);
            PaymentDTO paymentDTO1 = new PaymentDTO(command.getPayment());
            log.info("Prueba123...");
            return ResponseEntity.ok(paymentDTO1);
        }
        else{
            log.info("Prueba...");
            if (paymentDTO.getPaymentMethod().isEmpty()){
                throw new RequestException("Prueba","P-401");
            }
            if(paymentDTO.getPaymentValue().isNaN()){
                throw new RequestException("Prueba","P-402");
            }
            if(paymentDTO.getOrderReference() == null){
                throw new RequestException("Prueba","P-403");
            }
            if( UUID.fromString(paymentDTO.getOrderReference()) == null ){

            }

        }
        return ResponseEntity.ok().build();
    }

   /*   @GetMapping
    public ResponseEntity<Stream<PaymentDTO>> getPaymentsAll() throws Exception {
         GetPaymentQuery query = new GetPaymentQuery();
         queryBus.handle(query);
         return ResponseEntity.ok(query.getPaymentsAll().map(payment -> new PaymentDTO(payment)));
     }*/
    /*
     @GetMapping("/{paymentReference}")
     public ResponseEntity<PaymentDTO> getPaymentReference(String paymentReference) throws Exception {
         Payment payment = new Payment();
         payment.setPaymentReference(PaymentMapper.builder().build().transformPaymentReference(paymentReference));
         GetPaymentQuery query = new GetPaymentQuery(payment);
         queryBus.handle(query);
         return ResponseEntity.ok(new PaymentDTO(query.getPayment()));
     }*/

}
