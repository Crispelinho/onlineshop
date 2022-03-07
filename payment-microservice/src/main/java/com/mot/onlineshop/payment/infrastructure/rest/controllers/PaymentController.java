package com.mot.onlineshop.payment.infrastructure.rest.controllers;

import com.mot.onlineshop.payment.application.command.CreatePaymentCommand;
import com.mot.onlineshop.payment.application.commandbus.CommandBus;
import com.mot.onlineshop.payment.application.query.GetPaymentQuery;
import com.mot.onlineshop.payment.application.querybus.QueryBus;
import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.infrastructure.exceptions.BusinessException;
import com.mot.onlineshop.payment.infrastructure.exceptions.RequestException;
import com.mot.onlineshop.payment.infrastructure.rest.DTO.PaymentDTO;
import com.mot.onlineshop.payment.infrastructure.rest.mappers.PaymentMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;
import java.util.regex.Pattern;
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
        if(paymentDTO.getPaymentMethod() != null && paymentDTO.getPaymentValue() != null
                && paymentDTO.getOrderReference() != null)
        {
            try{
                Payment.PaymentMethod paymentMethod = Payment.PaymentMethod.valueOf(paymentDTO.getPaymentMethod());

            }catch (IllegalArgumentException ex){
                throw new BusinessException("P-301", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            if(paymentDTO.getPaymentValue().isNaN() || paymentDTO.getPaymentValue() <= 0){
                throw new BusinessException("P-302", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            Pattern p = Pattern.compile("^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{4}-[89ab][0-9a-f]{4}-[0-9a-f]{12}$");
            if( p.matcher(paymentDTO.getOrderReference()).matches() || paymentDTO.getOrderReference().isEmpty()){
                throw new BusinessException("P-303", HttpStatus.INTERNAL_SERVER_ERROR);
            }

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
            return ResponseEntity.ok(paymentDTO1);
        }
        else{
            if (paymentDTO.getPaymentMethod()==null || paymentDTO.getPaymentMethod().isEmpty()){
                throw new RequestException("P-401");
            }
            if(paymentDTO.getPaymentValue()==null){
                throw new RequestException("P-402");
            }
            if(paymentDTO.getOrderReference() == null || paymentDTO.getOrderReference().isEmpty()){
                throw new RequestException("P-403");
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
