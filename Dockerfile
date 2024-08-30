FROM gradle:8.8-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle build --no-daemon
CMD ["gradle", "test", "--no-daemon"]