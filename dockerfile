FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . /app
RUN mvn -B clean package

FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/cloudcomputing-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
