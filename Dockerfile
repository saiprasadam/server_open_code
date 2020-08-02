FROM openjdk:8-jdk-alpine

ENV SPRING_PROFILES_ACTIVE docker

EXPOSE 8080

RUN mkdir -p /build

WORKDIR /build

COPY target/*.jar app.jar

RUN chmod 777 app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
