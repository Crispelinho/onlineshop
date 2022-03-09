package com.mot.onlineshop.payment.infrastructure.bus;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mot.onlineshop.payment.application.querybus.Query;
import com.mot.onlineshop.payment.application.querybus.QueryBus;
import com.mot.onlineshop.payment.application.querybus.QueryHandler;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class InMemoryQueryBus implements QueryBus {

    private Map<Class, QueryHandler> handlers;

    public InMemoryQueryBus(List<QueryHandler> queryHandlerImplementations) {
        this.handlers = new HashMap<>();
        queryHandlerImplementations.forEach(queryHandler -> {
            Class queryClass = getQueryClass(queryHandler);
            handlers.put(queryClass, queryHandler);
        });
    }

    @Override
    public <T> T handle(Query<T> query) throws Exception {
        if (!handlers.containsKey(query.getClass())) {
            throw new Exception(String.format("No handler for %s", query.getClass().getName()));
        }
        return (T) handlers.get(query.getClass()).handle(query);
    }

    private Class<?> getQueryClass(QueryHandler handler) {
        Type commandInterface = ((ParameterizedType) handler.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[1];
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
