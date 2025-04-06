# Dockerfile for Spring Boot Application
FROM openjdk:17-jdk-slim


# Information about the maintainer of the image
MAINTAINER eazybytes.com


# Add the application jar to the container
COPY ./target/accounts-0.0.1-SNAPSHOT.jar accounts.jar

# execute the jar file
ENTRYPOINT ["java", "-jar", "accounts.jar"]