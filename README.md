# Online Shop

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

Web project based on hexagonal architecture and DDD using Spring Boot and Gradle, for the development of an Online Store implementing the PayU payment platform.

An integration is carried out with the PayU payment platform in which the payment creation and payment refund operations are implemented.

The CQRS pattern is implemented to separate read and update operations, maximizing application performance, scalability and security;

The event sourcing pattern for the traceability of business operations.

And the saga pattern with choreography for communication between the different microservices, each service or microservice will communicate with others through events to decide the next action to perform (Event-Driven Architecture).

PayU documentation: http://developers.payulatam.com/latam/en/docs/integrations


## Businnes 

### C4 Model

The C4 model was implemented to visualize the architecture of the project

#### Context Diagram

![_C4 Diagram - Shop Online-System Context Diagram drawio](https://user-images.githubusercontent.com/23733231/158483457-be152422-13e3-43c1-941e-6e0d52716e76.png)

#### Containers  Diagram

![_C4 Diagram - Shop Online-Container Diagram drawio](https://user-images.githubusercontent.com/23733231/159053594-416c3577-b796-4bff-9f59-b7a724f9dbc3.png)

#### Components Diagram

![_C4 Diagram - Shop Online-Component Diagram drawio](https://user-images.githubusercontent.com/23733231/159053626-1ede5fa7-a127-48a0-a9fc-7df1fff04df5.png)

#### Class Diagram


### Data Diagram

![_C4 Diagram - Shop Online-Data Diagram drawio](https://user-images.githubusercontent.com/23733231/159053847-d4045d56-cfe1-4c45-8f30-5d9303e903eb.png)

### Package Diagram

![_C4 Diagram - Shop Online-Package Diagram drawio](https://user-images.githubusercontent.com/23733231/159053674-44a3c858-9615-4429-8ba4-76ac32bff59e.png)


### Secuence Diagram

#### Happy Path

![Sequence Diagram Happy Path Payment-Page-1](https://user-images.githubusercontent.com/23733231/159086163-71451f62-6bf9-4261-ba74-93ea7980b6f5.png)


#### Sad Path

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
> ```cd onlineshop```
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
    "orderReference": "034acc05-35cc-41b7-ab30-5cc4e729fb43",
    "payload":{
        "state":"SEND_PAYMENT",
        "provider":"PAYU"
      }
    }
```

#### Get a payment

From Postman we can send the following request in JSON format to the endpoint http://localhost:8080/payment/{paymentReference}:


#### Make a refund to a payment made


From Postman we can send the following request in JSON format to the endpoint http://localhost:8080/payment/refund:

```json
{
    "paymentReference": "7d45a3ba-4718-4663-89fa-90b7612c0885",
    "description":"Reason for requesting the void of the transaction",
    "payload":{
        "state":"SEND_REFUND",
        "provider":"PAYU"
    }
}
```
