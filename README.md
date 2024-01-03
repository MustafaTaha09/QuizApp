# QuizApp
## Introduction
A back-end Quiz Application that allows you to create a list of random questions and submit your answers accordingly.
Develop using the spring framework and MySQL database.
Validation through every API request was implemented using Response Entity to handle HTTP requests effeciently
Project is still in early stages of development.

## Features
The app allows you to do the following:
- Perform all CRUD operations on all questions
- Create a quiz based on difficulty level  
- Create a quiz picking random limited number from the DB
- Submit User answers
- Calculate & Display the score based on user's answers 
- Validation on every RESTful API request using Response Entity.

## Backend
Used Java and Spring Boot for building the back-end server using the following:
- Spring Data: mainly utilizing the JPA repo, JPQL and native queries when needed
- Spring REST: create RESTful APIs to facilitate communication future front-end part.
- Spring MVC

## Dependencies
- Java 17 SDK
- Embedded Tomcat server
- MySQL Database
- Maven



