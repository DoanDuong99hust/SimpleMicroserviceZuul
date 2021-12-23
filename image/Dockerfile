FROM java:8
FROM maven:alpine
# image layer
WORKDIR /app/image
# Image layer: with the application
COPY ./image /app/image
RUN mvn -v
RUN mvn clean install -DskipTests

ENTRYPOINT ["java", "-Deureka.client.serviceUrl.defaultZone=http://eureka:8761/eureka","-jar","/app/image/target/spring-eureka-team-0.0.1-SNAPSHOT.jar"]