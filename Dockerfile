# Dockerfile (recomendado)
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copia el jar (cualquier jar en target/)
COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "exec java -jar /app/app.jar"]
