package com.mot.onlineshop.payment.application.querybus;

import com.mot.onlineshop.payment.application.querybus.Query;

public interface QueryBus {
    <T> T handle(Query<T> query) throws Exception;
}
