package com.mot.onlineshop.payment.application.commandbus;

public interface CommandHandler<T extends Command> {
    void handle(T command) throws Exception;
}
