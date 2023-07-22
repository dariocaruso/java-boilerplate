###############
# Build stage #
###############
FROM maven:3.8-openjdk-15 as build

# Copy local code to the container image.
COPY . .

# Build a release artifact.
RUN mvn clean package


#################
# Package stage #
#################
FROM adoptopenjdk/openjdk15:alpine

# Copy the jar to the production image from the builder stage.
COPY --from=build /target/*.jar app.jar

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
VOLUME /tmp

EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]