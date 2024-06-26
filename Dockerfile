FROM gradle:jdk22-alpine as build
LABEL maintainer="minhbangod@gmail.com"
WORKDIR /app
#copy file
COPY build.gradle .
COPY settings.gradle .

#copy source code
COPY src ./src

# Build application
RUN gradle clean build --no-daemon

FROM openjdk:24-ea-3-jdk-oraclelinux9

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]

