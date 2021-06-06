# Twitter-Clone-API

This is a twitter-clone backend application made on top of Spring Boot, a Java framework. To run this application the following requirements are needed:

JDK 1.8 or more
Spring Boot framework compatible IDE.
Postman or any other API testing tool.
In memory SQL Database: H2
Functionalities along with APIs:

User Registration: /register
Request Type: POST
Sample POST Request Body:
  {
      "userName": "shraban",
      "password": "tweet@123",
      "fullName":"Shraban Karmakar"
  }
LogIn: /login
Request Type: POST
Sample POST Request Body:
  {
      "userName": "shraban",
      "password": "tweet@123"
  }
LogOut: /logout
Request Type: POST
Sample POST Request Body.
