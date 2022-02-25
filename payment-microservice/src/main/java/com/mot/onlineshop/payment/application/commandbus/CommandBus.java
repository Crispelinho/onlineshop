package com.mot.onlineshop.payment.application.commandbus;

public interface CommandBus {
    void handle(Command command) throws Exception;
}
