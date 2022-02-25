package com.mot.onlineshop.payment.application.command;

import com.mot.onlineshop.payment.application.commandbus.CommandHandler;
import com.mot.onlineshop.payment.application.usecases.CreatePaymentUseCase;
import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.domain.models.PaymentId;
import com.mot.onlineshop.payment.domain.persistence_ports.PaymentPersistence;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component @AllArgsConstructor
public class CreatePaymentCommandHandler implements CommandHandler<CreatePaymentCommand> {
    private PaymentPersistence paymentPersistence;
    private CreatePaymentUseCase useCase;

    @Override
    public void handle(CreatePaymentCommand command) throws Exception {
        System.out.println("Create payment");
        PaymentId paymentId = command.getPayment().getPaymentReference();
        useCase.handle(paymentId, command.getPayment());
    }

}
