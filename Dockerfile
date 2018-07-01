FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/claudsan-1.0.0.jar microservices-app.jar  
ENTRYPOINT ["java", "-jar", "/microservices-app.jar"]