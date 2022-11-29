FROM maven:3.6.3-openjdk-14-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -B package --file pom.xml -DskipTests

FROM openjdk:14-slim
RUN apt-get update && apt-get install -y curl
COPY --from=build /workspace/target/shipping-service-example-*-SNAPSHOT-spring-boot.jar app.jar
CMD java -jar /app.jar