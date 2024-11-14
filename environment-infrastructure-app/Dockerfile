#
# Build app
#

FROM maven:3.8.5-openjdk-17-slim AS build
COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean test package

#
# Package app
#

FROM tomcat:9.0

LABEL maintainer="gl"

COPY --from=build /app/target/environment-infrastructure-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/environment-infrastructure.war
COPY server.xml /usr/local/tomcat/conf/ 