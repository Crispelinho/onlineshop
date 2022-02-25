package com.mot.onlineshop.payment.application.query;

import com.mot.onlineshop.payment.application.querybus.QueryHandler;
import com.mot.onlineshop.payment.application.usecases.GetPaymentUseCase;
import com.mot.onlineshop.payment.domain.models.Payment;
import org.springframework.stereotype.Component;

@Component
public class GetPaymentQueryHandler implements QueryHandler<Payment, GetPaymentQuery> {
    private GetPaymentUseCase useCase;

    public GetPaymentQueryHandler(GetPaymentUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Payment handle(GetPaymentQuery query) throws Exception {
        return useCase.handle(query.getPayment());
    }
}
