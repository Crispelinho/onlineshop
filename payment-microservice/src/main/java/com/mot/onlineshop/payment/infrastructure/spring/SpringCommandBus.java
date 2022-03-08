package com.mot.onlineshop.payment.infrastructure.spring;


import com.mot.onlineshop.payment.application.commandbus.Command;
import com.mot.onlineshop.payment.application.commandbus.CommandBus;
import com.mot.onlineshop.payment.application.commandbus.CommandHandler;
import java.lang.reflect.ParameterizedType;

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
public class SpringCommandBus implements CommandBus {

    private Map<Class, CommandHandler> handlers;

    private static Logger log = LogManager.getLogger(SpringCommandBus.class);

    public SpringCommandBus(List<CommandHandler> commandHandlerImplementations) {
        this.handlers = new HashMap<>();
        commandHandlerImplementations.forEach(commandHandler -> {
            Class<?> commandClass = getCommandClass(commandHandler);
            handlers.put(commandClass, commandHandler);
        });
    }

    @Override
    public void handle(Command command) throws Exception {
        String methodSignature = "Inicializando método handle en SpringCommandBus";
        log.info(methodSignature);
        if (!handlers.containsKey(command.getClass())) {
            throw new Exception(String.format("No handler for %s", command.getClass().getName()));
        }
        handlers.get(command.getClass()).handle(command);
    }

    private Class<?> getCommandClass(CommandHandler handler) {
        Type commandInterface = ((ParameterizedType) handler.getClass().getGenericInterfaces()[0])
                .getActualTypeArguments()[0];
        return getClass(commandInterface.getTypeName());
    }

    private Class<?> getClass(String name) {
        try {
            return Class.forName(name);
        } catch (Exception e) {
            return null;
        }
    }
}
