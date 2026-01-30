# ===== Build stage =====
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests


# ===== Runtime stage =====
FROM eclipse-temurin:21-jre

WORKDIR /app

# Kopieer de jar uit de build stage
COPY --from=build /app/target/*.jar app.jar

# Expose poort (meestal 8080 voor Spring Boot)
EXPOSE 8080

# Start de applicatie
ENTRYPOINT ["java", "-jar", "app.jar"]
