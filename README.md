# Online Shop
Web project based on hexagonal architecture and DDD using Spring Boot and Gradle, for the development of an Online Store implementing the PayU payment platform.

# Project Structure

```bash
├── com.onlineshop.payment/
│   ├── application/
│   │   ├── command/
│   │   │   ├── CreatePaymentCommand.java
│   │   │   ├── CreatePaymentCommandHandler.java
│   │   │   ├── RefundPaymentCommand.java
│   │   │   ├── RefundPaymentCommandHandler.java
│   │   ├── commandbus/
│   │   │   ├── Command.java
│   │   │   ├── CommandBus.java
│   │   │   ├── Commandhandler.java
│   │   ├── query/
│   │   │   ├── CreatePaymentCommand.java
│   │   │   ├── CreatePaymentCommandHandler.java
│   │   ├── querybus/
│   │   │   ├── Query.java
│   │   │   ├── QuerydBus.java
│   │   │   ├── QueryHandler.java
│   │   ├── usecases/
│   │   │   ├── CreatePaymentUseCase.java
│   │   │   ├── GetPaymentUseCase.java
│   │   │   ├── RefundPaymentUseCase.java
│   ├── domain/
│   │   ├── interfaces/
│   │   ├── iPaymentRequest.java
|   |   ├── iPaymentResponse.java
│   │   ├── models/
│   │   ├── Payment.java
|   |   ├── PaymentId.java
│   │   ├── ports/
│   │   │   ├── clients/
│   │   │   │   ├── ApiClient.java
│   │   │   │   ├── PaymentProvider.java
│   │   │   ├── persistence/
│   │   │   │   ├── PaymentPersistence.java
│   │   ├── shared/
│   │   │   ├── domaineventbus/
│   │   │   │   ├── DomainEvent.java
│   │   │   │   ├── DomainEventBus.java
│   │   │   │   ├── DomainEventCollection.java
│   │   │   │   ├── DomainEventId.java
│   ├── infrastructure/
│   │   │   ├── bus/
│   │   │   │   ├── InMemoryCommandBus.java
│   │   │   │   ├── InMemoryEventBus.java
│   │   │   │   ├── InMemoryQueryBus.java
│   │   │   ├── exceptions/
│   │   │   ├── constants/
│   │   │   │   ├── ExceptionsContants.java
│   │   │   ├── BusinessExeception.java
│   │   │   ├── RequiredException.java
│   │   │   ├── kafka/
│   │   │   ├── PaymentProducer.java
│   │   │   ├── models/
│   │   │   │   ├── converters/
│   │   │   │   ├── ModelConverter.java
│   │   │   │   ├── ModelConverterImp.java
│   │   │   │   ├── provider/
│   │   │   │   │   ├── PayU/
│   │   │   │   │   │   ├── merchant/
│   │   │   │   │   │   ├── payed/
│   │   │   │   │   │   ├── threedomainsecure/
│   │   │   │   │   │   ├── transaction/
│   │   │   │   │   │   ├── transactionresponse/
│   │   │   │   │   │   ├── PaymentRefund.java
│   │   │   │   │   │   ├── PaymentRequest.java
│   │   │   │   │   │   ├── PaymentResponse.java
│   │   │   │   │   │   ├── PayURequest.java
│   │   │   │   │   │   ├── PayURequestRefund.java
│   │   │   │   │   │   ├── PayUResponse.java
│   │   │   │   │   │   ├── PayUResponseRefund.java
│   │   │   │   ├── shared/
│   │   │   │   │   │   ├── orderms/
│   │   │   │   │   │   ├── userms/
│   │   │   │   │   │   ├── Config.java
│   │   │   │   │   │   ├── Payload.java
│   │   │   ├── persistence/
│   │   │   │   ├── DAOS/
│   │   │   │   ├── entities/
│   │   │   │   ├── memory/
│   │   │   │   ├── postgres/
│   │   │   ├── rest/
│   │   │   │   ├── clients/
│   │   │   │   ├── constants/
│   │   │   │   ├── controllers/
│   │   │   │   ├── DAOS/
│   │   │   │   ├── DTO/
│   │   │   │   ├── mappers/
│   │   │   │   ├── transform/
│   │   │   ├── validators/
│   │   │   │   │  ├── PaymentValidator.java
└── OnlineshopApplication.java
```
