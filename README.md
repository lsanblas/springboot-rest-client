# springboot-rest-client
 Project to demostrate the use of a REST API  with various REST Clients types

 ## API REST

 The project use the a Fake REST API https://jsonplaceholder.typicode.com/ create for testing and prototyping.

 ## REST Clients

RestClient - synchronous client with a fluent API.

RestTemplate - synchronous client with template method API.

HTTP Interface - annotated interface with generated, dynamic proxy implementation.

Spring Cloud OpenFeign - declarative REST client.

## DEMO

To test each type of client the project publish a REST Controller in the URL http://localhost:8080/api/v1/users/. Please, use the Swagger Endpoint http://localhost:8080/swagger-ui/index.html for easy testing.
