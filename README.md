# Customer Service

### Requirements

1. JDK 8
1. Maven 3

### Running

1. Clone : `https://github.com/rayansalewski/tokio-test-interview.git`
1. Go to the folder `tokio-test` and execute: `mvn spring-boot:run`

### Request methods

| Command | URI | JSON |
| --- | --- | --- |
| `List all Customer` | GET http://localhost:8080/customers | NA
| `List Customer by id` | GET http://localhost:8080/customers/{id} | NA
| `Insert Customer` | POST http://localhost:8080/customers | { "name": "String","email":"String" }
| `Delete Customer` | DELETE http://localhost:8080/customers/{id} | NA
| `Update Customer` | PUT http://localhost:8080/customers/{id} | { "name": "String","email":"String" }
| `Add Address Custumer` | POST http://localhost:8080/customers/{id}/address | { "street" : "String", "number" : int, "state" : "String" }




