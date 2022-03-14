package com.mot.onlineshop.payment.application.command;

import com.mot.onlineshop.payment.application.commandbus.CommandHandler;
import com.mot.onlineshop.payment.application.usecases.RefundPaymentUseCase;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component @AllArgsConstructor
public class RefundPaymentCommandHandler implements CommandHandler<RefundPaymendCommand> {
    private RefundPaymentUseCase refundPaymentUseCase;

    private static final Logger log = LogManager.getLogger(RefundPaymentCommandHandler.class);

    @Override
    public void handle(RefundPaymendCommand command) throws Exception {
        command.setPayment(refundPaymentUseCase.handle(command.getPayment()));
    }
}
