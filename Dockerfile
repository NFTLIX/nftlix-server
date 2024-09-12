FROM eclipse-temurin:17-jdk-alpine

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","-Duser.timezone=Asia/Seoul","/app.jar"]