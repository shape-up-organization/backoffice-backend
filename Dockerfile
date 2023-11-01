FROM openjdk:17-jdk-slim
ENV LOGGING_FILE_NAME /logs/backoffice-service.log

RUN mkdir /logs

COPY ./build/libs/*SNAPSHOT.jar app.jar

EXPOSE 7003

ENTRYPOINT ["java", "-Dspring.profiles.active=local", "-jar", "/app.jar"]



