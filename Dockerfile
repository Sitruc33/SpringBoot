FROM eclipse-temurin:21-jdk
MAINTAINER alexcurtis.com
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]