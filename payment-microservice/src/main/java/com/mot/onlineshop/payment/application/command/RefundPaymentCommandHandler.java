package com.mot.onlineshop.payment.application.command;

import com.mot.onlineshop.payment.application.commandbus.CommandHandler;
import com.mot.onlineshop.payment.application.constants.AppPaymentConstants;
import com.mot.onlineshop.payment.application.usecases.RefundPaymentUseCase;
import com.mot.onlineshop.payment.domain.interfaces.EventRepository;
import com.mot.onlineshop.payment.domain.models.event.EventId;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component @AllArgsConstructor
public class RefundPaymentCommandHandler implements CommandHandler<RefundPaymendCommand> {
    private RefundPaymentUseCase refundPaymentUseCase;
    private EventRepository eventRepository;

    private static final Logger log = LogManager.getLogger(RefundPaymentCommandHandler.class);

    @Override
    public void handle(RefundPaymendCommand command) throws Exception {
        log.info(AppPaymentConstants.EXECUTING_COMMAND_HANDLER +"RefundPaymentCommandHandler");
        EventId eventId = eventRepository.getId();
        command.setPayment(refundPaymentUseCase.handle(eventId,command.getPayment()));
    }
}
