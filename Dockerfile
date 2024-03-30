FROM maven:3.9.6-eclipse-temurin-21-alpine AS builder
WORKDIR /app
COPY src/ src
COPY pom.xml ./
RUN mvn package

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/java-hello-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "java-hello-0.0.1-SNAPSHOT.jar"]