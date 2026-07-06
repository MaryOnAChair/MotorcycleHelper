# Build Stage
FROM eclipse-temurin:26-jdk-jammy AS builder
WORKDIR /app
COPY mvnw .
COPY .mvn/ .mvn/
COPY pom.xml .
COPY src ./src
RUN chmod +x mvnw && ./mvnw clean package -DskipTests
# Runtime Stage
FROM eclipse-temurin:26-jre-jammy AS runtime
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*
RUN groupadd -r spring && useradd -r -g spring spring
USER spring
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

