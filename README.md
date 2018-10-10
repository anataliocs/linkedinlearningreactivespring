# LinkedIn Learning Reactive Spring Demo Application

### Contact:
* anataliocs@gmail.com

### Profiles
* https://www.linkedin.com/in/anataliocs/
* http://stackoverflow.com/story/anataliocs

## About this Application

### How to build/run this application

Navigate to the project root directory to run these commands.

Build Application:

`./gradlew clean build`

Run Application: 

`./gradlew bootRun`

## Running MongoDB

Pull the latest Docker image
`docker pull bitnami/mongodb`

Run the container
`docker run -p 27017:27017 --name mongodb bitnami/mongodb:latest` 

### Application Design Summary

**Technologies Used:**  
- Java 10
- Spring Boot 2
- Spring 5
- Spring Web Flux
- Gradle


### Testing

Run Tests:

`./gradlew clean build test`



