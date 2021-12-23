FROM java:8
FROM maven:alpine
# image layer
WORKDIR /app/gallery
# Image layer: with the application
COPY ./gallery /app/gallery
RUN mvn -v
RUN mvn clean install -DskipTests

ENTRYPOINT ["java", "-Deureka.client.serviceUrl.defaultZone=http://eureka:8761/eureka","-jar","/app/gallery/target/gallery-0.0.1-SNAPSHOT.jar"]