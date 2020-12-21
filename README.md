# ONEIO Assignment - FizzBuzz Game
The project has been developed for ONEIO as a recruitment assignment test. Following are the details regarding to the technologies used and accessing the application.

This application is a FizzBuzz Game which takes "three" inputs from the user 1. Number 2. Divisible1 3. Divisible2 and returns the list of fizzbuzz responses. The application has two parts, first part is the rest api and the other is the frontend part and both of them are deployed as microservices on docker and to simply the deployment more Docker Compose has been used. The services are also deployed on Amazon AWS using Elastic beanstalk. Steps and urls to run the services on local as well as production (aws) is described below.

# Key technologies/frameworks:

1. Java 8
2. Spring Boot v2.4.1
3. Thymeleaf 
4. Bootstrap 3.4.1
5. jQuery 3.5.1
6. Docker v20.10.0
7. Docker Compose v1.27.4
8. Amazon Elastic Beanstalk

# Deploy and Access the application on local
In order to deploy the application on local, a docker compose file resides in the root directory of the project and "docker-compose up" command should issued to deploy the application on local and can be accessed using http://localhost:8081/. In order to access the api directly the url is http://localhost:8080/api/fizzbuzz/{number}/{d1}/{d2} where {number}, {divisible1}, and {divisible2} should be replaced with respective numbers.

# Acessing applicaiton on Production (Amazon)
Following are the urls used to access the application on Amazon.

1. Accessing the User Interface - http://fizzbuzzui-env.eba-pa3midji.eu-west-2.elasticbeanstalk.com/
2. Accessing the API - http://oneiofizzbuzz-env.eba-snyqawkc.eu-west-2.elasticbeanstalk.com/api/fizzbuzz/100/3/5

