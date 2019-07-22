# eSiteware Server
This API was built as part of the process for a job position. It's built in Java using Maven as project manager, Spring Boot
as main framework and a Postgres database hosted at Azure.

The archteture of the application is based on REST. It has a controller layer, responsible for delegating logic from each endpoind
to it's service.
The service layer is responsible for all the service logic on the system. Each entity has it's own service.
The DAO is responsible for the persistence services for the entities.

To run the project, you need Maven installed at your computer. Then, just run the command mvn spring-boot:run from the terminal
on the root directory of the application. The application is already connected to a instance of a database in the Azure cloud service,
no additional configuration is required.
