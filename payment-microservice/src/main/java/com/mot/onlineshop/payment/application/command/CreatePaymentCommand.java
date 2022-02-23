package com.mot.onlineshop.payment.application.command;

import com.mot.onlineshop.payment.domain.model.Payment;

public class CreatePaymentCommand extends Command{
    private Payment payment;

    public CreatePaymentCommand(Payment payment){
        this.payment = payment;
    }

}