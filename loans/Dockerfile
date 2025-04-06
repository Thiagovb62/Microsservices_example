FROM openjdk:17-jdk-slim

MAINTAINER eazybytes.com

# Add the application jar to the container
COPY ./target/loans-0.0.1-SNAPSHOT.jar loans.jar

ENTRYPOINT ["java", "-jar", "loans.jar"]