FROM maven:3-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src
COPY MANIFEST.MF manifest.mf
RUN mvn dependency:resolve

#RUN mvn clean package -DskipTests
RUN mvn compile

#RUN ls /app/target

FROM openjdk:17-jdk-slim
#FROM ubuntu:22.04

WORKDIR /app

#RUN apt-get update && apt-get install -y openjdk-17-jdk

#COPY --from=build /app/target/*.jar app.jar
COPY --from=build /app/target/classes /app/classes
COPY --from=build /app/src/main/resources /app/resources

ENV MAIN_CLASS=com.com.hmi.router.Application

#CMD ["java", "-cp", "app/classes:/app/resources", "com.hmi.router.Application"]

#CMD ["java", "-jar", "app.jar"]