package com.mot.onlineshop.payment.application.querybus;

public interface QueryBus {
    <T> T handle(Query<T> query) throws Exception;
}
