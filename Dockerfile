FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY /build/libs/forSber-1.0-SNAPSHOT.jar /app/forSber.jar
ENTRYPOINT ["java","-jar","forSber.jar"]