package com.mot.onlineshop.payment.application.command;

import com.mot.onlineshop.payment.application.commandbus.Command;
import com.mot.onlineshop.payment.domain.models.payment.Payment;
import lombok.*;

@Getter @Setter @EqualsAndHashCode @ToString
@AllArgsConstructor
public class CreatePaymentCommand extends Command {
    private Payment payment;
}