package com.mot.onlineshop.payment.infrastructure.eventbus.memory;


import com.mot.onlineshop.payment.application.commandbus.Command;
import com.mot.onlineshop.payment.application.commandbus.CommandBus;
import com.mot.onlineshop.payment.application.commandbus.CommandHandler;
import java.lang.reflect.ParameterizedType;

import com.mot.onlineshop.payment.infrastructure.exceptions.TechnicalException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Primary
public class InMemoryCommandBus implements CommandBus {

    private Map<Class, CommandHandler> handlers;

    private static Logger log = LogManager.getLogger(InMemoryCommandBus.class);

    public InMemoryCommandBus(List<CommandHandler> commandHandlerImplementations) {
        String methodSignature = "Initialization method InMemoryCommandBus in InMemoryCommandBus";
        log.info(methodSignature);
        this.handlers = new HashMap<>();
        commandHandlerImplementations.forEach(commandHandler -> {
            Class<?> commandClass = getCommandClass(commandHandler);
            handlers.put(commandClass, commandHandler);
        });
    }

    @Override
    public void handle(Command command) throws Exception {
        String methodSignature = "Initialization method handle in InMemoryCommandBus";
        log.info(methodSignature);
        if (!handlers.containsKey(command.getClass())) {
            throw new TechnicalException("T-502",command.getClass().getName());
        }
        handlers.get(command.getClass()).handle(command);
    }

    private Class<?> getCommandClass(CommandHandler handler) {
        String methodSignature = "Initialization method getCommandClass in InMemoryCommandBus";
        log.info(methodSignature);
        Type commandInterface = ((ParameterizedType) handler.getClass().getGenericInterfaces()[0])
                .getActualTypeArguments()[0];
        return getClass(commandInterface.getTypeName());
    }

    private Class<?> getClass(String name) {
        String methodSignature = "Initialization method getClass in InMemoryCommandBus";
        log.info(methodSignature);
        try {
            return Class.forName(name);
        } catch (Exception e) {
            return null;
        }
    }
}
