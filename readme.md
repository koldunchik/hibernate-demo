## Demo of JPA + Hibernate + MySQL in Spring Boot

### Usage

- Run the application and go on http://localhost:8080/
- Use the following urls to invoke controllers methods and see the interactions
  with the database:
    * `/all - see all files from the database
    * `/delete?id=[id]`: delete the file from the database with the passed id.

### Build and run

#### Configurations

Open the `application.properties` file and set your own configurations for the
database connection.

#### From terminal

Go on the project's root folder, then type:

    $ mvn spring-boot:run

