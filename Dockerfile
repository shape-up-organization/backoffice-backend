FROM openjdk:17-jdk-slim

COPY ./build/libs/backoffice-1.0.0.jar app.jar

EXPOSE 7003

ENTRYPOINT ["java", "-Dspring.profiles.active=local", "-jar", "/app.jar"]
