# --- Stage 1: Build the Application ---
# Use a Maven image that is based on Eclipse Temurin (supported Java)
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copy your project files
COPY . .

# Run Maven to create the .jar file
RUN mvn clean package -DskipTests

# --- Stage 2: Run the Application ---
# FIX: Switched from 'openjdk:17-jdk-slim' (deleted) to 'eclipse-temurin' (supported)
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copy the built jar file from the 'build' stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Start the app
ENTRYPOINT ["java", "-jar", "app.jar"]