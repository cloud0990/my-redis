FROM maven:3.8.1-openjdk-21 AS build
WORKDIR /app
COPY src /app/src
COPY pom.xml /app
RUN mvn clean package

FROM openjdk:21
WORKDIR /app
ARG JAR_FILE=study-project
ARG APP_VERSION=0.0.1-SNAPSHOT
COPY /target/${JAR_FILE}-${APP_VERSION}.jar /app/application.jar

#"hosts": ["endpoint|redacted"],
ENTRYPOINT ["java", "-jar", "/app/application.jar"]