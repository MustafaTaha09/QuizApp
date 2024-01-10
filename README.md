# QuizApp
## Introduction
- A back-end Quiz Application that allows you to create a quiz contained of random questions and submit your answers accordingly then calculate your answer.
- Developed using Java, the spring framework and MySQL database.
- Validation through every API request was implemented using Response Entity to handle HTTP requests effeciently.
- Authentication of users based on their given roles(Employee, Manager, Admin) in the DB using JDBC Auth.
- Project is still in early stages of development.

## Features
The app allows you to do the following:
- Perform all CRUD operations on all questions using Spring Data REST
- Create a quiz based on difficulty level
- Create a quiz picking random limited number from the DB
- Submit User answers
- Calculate & Display the score based on user's answers
- Validation on every RESTful API request using Response Entity

## Backend
Used Java and Spring Boot for building the back-end server using the following:
- Spring Data JPA: mainly utilizing the JPA repo, JPQL and native queries when needed
- Spring Data REST: Reduce boiler plate code by automatically creating endpoints
- Spring Security: URI restriction to certain users based on their roles.
- Spring boot: Create specific RESTful APIs to facilitate communication to future front-end part.
- Spring MVC

## Dependencies
- Java 17 SDK
- Embedded Tomcat server
- MySQL Database
- Maven

### Design Patterns
- Dependency Injection
- DAO (Data Access Object)
- MVC



