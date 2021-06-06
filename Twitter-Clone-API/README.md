# twitter-clone

This is a _twitter-clone_ backend application made on top of _Spring Boot_, a Java framework.
To run this application the following requirements are needed:
   * JDK 1.8 or more
   * Spring Boot framework compatible IDE.
   * Postman or any other API testing tool.
   * In memory SQL Database: H2
  
 **Functionalities along with APIs**:
  1. User Registration: _/register_
        1. Request Type: POST
        2. Sample POST Request Body:
            ```js
            
              {
                  "userName": "shraban",
                  "password": "tweet@123",
                  "fullName":"Shraban Karmakar"
              }
            ```
   2. LogIn: _/login_
        1. Request Type: POST
        2. Sample POST Request Body:
            ```js
            
              {
                  "userName": "shraban",
                  "password": "tweet@123"
              }
            ```
   3. LogOut: _/logout_
        1. Request Type: POST
        2. Sample POST Request Body.
