# =========================
# STAGE 1 : BUILD
# =========================
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

# Copy Maven wrapper and project files
COPY mvnw ./ 
COPY .mvn .mvn
COPY pom.xml ./

# Fix line endings & permissions
RUN chmod +x mvnw && sed -i 's/\r$//' mvnw

# Pre-download dependencies (cached for faster rebuilds)
RUN --mount=type=cache,target=/root/.m2 \
    ./mvnw -q -DskipTests dependency:go-offline

# Copy the source and build the project
COPY src ./src
RUN --mount=type=cache,target=/root/.m2 \
    ./mvnw clean package -DskipTests
# 👆 This step actually creates /app/target/*.jar

# =========================
# STAGE 2 : RUNTIME
# =========================
FROM mcr.microsoft.com/openjdk/jdk:21-ubuntu AS runtime

WORKDIR /app

# Add non-root user
RUN addgroup --system spring && adduser --system --ingroup spring spring

# Buat folder upload dan kasih akses ke user spring
RUN mkdir -p /app/uploads && chown -R spring:spring /app/uploads

USER spring:spring

# Copy JAR from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port
EXPOSE 8080

# Set environment variable
ENV SERVER_PORT=8080

# Run the application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar --server.port=${SERVER_PORT}"]