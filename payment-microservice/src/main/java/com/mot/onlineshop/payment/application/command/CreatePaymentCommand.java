package com.mot.onlineshop.payment.application.command;

import com.mot.onlineshop.payment.application.commandbus.Command;
import com.mot.onlineshop.payment.domain.models.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class CreatePaymentCommand extends Command {
    private Payment payment;
}