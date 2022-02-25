package com.mot.onlineshop.payment.application.querybus;

import com.mot.onlineshop.payment.application.querybus.Query;

public interface QueryHandler<T, U extends Query<T>> {
    T handle(U query) throws Exception;
}
