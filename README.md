# Quarkus with PostgreSQL Integration

This project demonstrates how to connect a Quarkus application to a PostgreSQL database. It includes a simple REST endpoint that tests the database connection.

## Features

- PostgreSQL database integration with Quarkus
- REST endpoint to test database connectivity
- Configured with Agroal connection pool
- Ready for containerized deployment

## Screenshot

<!-- Add your screenshot here after uploading it to the repository -->
![Screenshot](screenshot.png)

## Prerequisites

- Java 17 or later
- Maven 3.9.6 or later
- PostgreSQL 12 or later

## Database Configuration

The application is configured to connect to a local PostgreSQL instance with the following default settings (configured in `src/main/resources/application.properties`):

```properties
quarkus.datasource.db-kind=postgresql
quarkus.datasource.username=postgres
quarkus.datasource.password=your_password
quarkus.datasource.jdbc.url=jdbc:postgresql://localhost:5432/your_database
```

## Setup PostgreSQL

1. Install PostgreSQL if not already installed
2. Create a database and user:
   ```sql
   CREATE DATABASE your_database;
   CREATE USER your_user WITH ENCRYPTED PASSWORD 'your_password';
   GRANT ALL PRIVILEGES ON DATABASE your_database TO your_user;
   ```

## Running the Application

### Development Mode

Run the application in dev mode that enables live coding:

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-postgres-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Provided Code

### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
