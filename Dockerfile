#Info to create container image with docker
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/awsproject-0.0.1-SNAPSHOT.jar app.jar
COPY .env .env

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]