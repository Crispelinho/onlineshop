package com.mot.onlineshop.application.command;

import com.mot.onlineshop.domain.model.Payment;

public class CreatePaymentCommand extends Command{
    private Payment payment;

    public CreatePaymentCommand(Payment payment){
        this.payment = payment;
    }

}