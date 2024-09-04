# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application's JAR file into the container
COPY target/club-world-cup-0.0.1-SNAPSHOT.jar /app/club-world-cup.jar

# Expose port 8080
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "club-world-cup.jar"]
