# Online Shop

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

Web project based on hexagonal architecture and DDD using Spring Boot and Gradle, for the development of an Online Store implementing the PayU payment platform.

The CQRS pattern is implemented to separate read and update operations, maximizing application performance, scalability and security;

The event sourcing pattern for the traceability of business operations.

And the saga pattern with choreography for communication between the different microservices, each service or microservice will communicate with others through events to decide the next action to perform (Event-Driven Architecture).

## Project Structure

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
## Base
This project was generated with Spring Boot and Gradle, H2 was used as data persistence engine.

Spring Actuator is implemented for the generation of the metrics, Prometheus for their processing and Grafana for their visualization.

## Installation for local test
  
Go to the project folder and run the following command:

### Project build
#### Windows
> ```gradlew clean build```
  
#### Linux and Mac
> ```cd apirest```
>  
> ```foo@bar:~$ .\gradlew clean build```

#### Running the app with Gradle
From Visual Studio Code or Intellij go to the OnlinedhopApplication class and run the project.

#### Tests

##### Create a payment

From Postman we can send the following request in JSON format to the endpoint http://localhost:8080/payment/:

```json
{
    "paymentMethod": "TC",
    "paymentValue": 23.0,
    "paymentCountry": "CO",
    "description":"Payment test description",
    "orderReference": "034acc05-35cc-41b7-ab30-5cc4e729fb43"
}
```

#### Get a payment

From Postman we can send the following request in JSON format to the endpoint http://localhost:8080/payment/{paymentReference}:


#### Make a refund to a payment made


From Postman we can send the following request in JSON format to the endpoint http://localhost:8080/payment/refund:

```json
{
    "paymentReferensce": "f5d3d623-6e94-4b14-8d83-4be4561f5559",
    "description":"Reason for requesting the void of the transaction"
}
```
