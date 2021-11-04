# todo-app
The todo app is a Restful web service in Spring Boot. 
Rest APIs make it possible to establish communication between a backend server and a frontend web or mobile applications.

## Spring boot

Spring boot was used using a "spring initializr".

## Dependencies

* Lombok
* Spring Web
* H2 Database ; is an in-memory database, meaning the data stored in the database is destroyed if the application is stopped or restarted.
* Spring Data JPA

## Notes:

* **Annotations**, the reason of usage of each annotation was explained in the code.

* This project uses **Builder Pattern**; The Builder Design Pattern is another creational pattern designed to deal with the construction of objects.

* The **CrudRespository interface** takes in the model and the type of the ID, in our case the model is Todo and the ID type is Long. Therefore, I was able to use all the CrudRepository methods save(), findOne(), findById(), findAll(), count(), delete(), deleteById() without providing implementation if needed.

* A **service** is an interface from which different implementations of the same functions can be made.

* A **data bootstrapper** creates and loads the initial data whenever the application runs. 
I made use of the **builder pattern** I mentionned while creating the Todo model.

* The **Testing of the crud endpoints** were done through Postman
